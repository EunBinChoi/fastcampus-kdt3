package me.smartstore.project.customers;
import java.util.Arrays;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Groups;

public class Customers {
    public static int SIZE = 10;
    private int count;
    private Customer[] customers;

    public Customers() {
        this.customers = new Customer[SIZE];
    }

    public int getCount() {
        return this.count;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        int realCount = 0;

        for(int i = 0; i < this.customers.length && this.customers[i] != null; ++i) {
            ++realCount;
        }

        return (Customer[])Arrays.copyOf(this.customers, realCount);
    }

    public int length() {
        return this.customers.length;
    }

    public boolean isNull() {
        return this.customers == null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void add(Customer customer) {
        if (this.count < SIZE) {
            this.customers[this.count] = customer;
            ++this.count;
        } else {
            this.extend(customer);
        }

    }

    public void insert(int index, Customer customer) {
        if (index < this.count) {
            if (this.count < SIZE) {
                Customer var10000 = this.customers[index];

                for(int i = this.customers.length - 1; i >= index; --i) {
                    this.customers[i + 1] = this.customers[i];
                }

                this.customers[index] = customer;
                ++this.count;
            } else {
                this.extend(index, customer);
            }

        }
    }

    public void extend(int index, Customer customer) {
        Customer[] copy = (Customer[])Arrays.copyOf(this.customers, this.customers.length);
        SIZE *= 2;
        this.customers = new Customer[SIZE];

        for(int i = 0; i < copy.length; ++i) {
            this.customers[i] = copy[i];
        }

        this.count = copy.length;
        this.insert(index, customer);
    }

    public void extend(Customer customer) {
        Customer[] copy = (Customer[])Arrays.copyOf(this.customers, this.customers.length);
        SIZE *= 2;
        this.customers = new Customer[SIZE];

        for(int i = 0; i < copy.length; ++i) {
            this.customers[i] = copy[i];
        }

        this.count = copy.length;
        this.add(customer);
    }

    public int pop(int index) {
        if (this.count == 0) {
            return -1;
        } else if (index >= 0 && index < this.count) {
            this.customers[index] = null;

            for(int i = index + 1; i < this.count; ++i) {
                this.customers[i - 1] = this.customers[i];
            }

            --this.count;
            return 1;
        } else {
            return -1;
        }
    }

    public int pop() {
        if (this.count == 0) {
            return -1;
        } else {
            this.customers[this.count - 1] = null;
            --this.count;
            return 1;
        }
    }

    public Customer get(int i) {
        return i < this.count ? this.customers[i] : null;
    }

    public void edit(int i, Customer customer) {
        this.customers[i] = customer;
    }

    public Customers findCustomers(GroupType type) {
        Customers custs = new Customers();
        if (custs != null) {
            for(int i = 0; i < this.count; ++i) {
                Customer cust = this.get(i);
                if (cust != null) {
                    Group grp = cust.getGroup();
                    if (type.equals(GroupType.NONE)) {
                        if (grp == null || grp.getType() == null || grp.getType().equals(GroupType.NONE)) {
                            custs.add(cust);
                        }
                    } else if (grp != null && grp.getType().equals(type)) {
                        custs.add(cust);
                    }
                }
            }
        }

        return custs;
    }

    public Customers findCustomers(Group grp) {
        if (grp != null) {
            if (grp.getType() != null) {
                return this.findCustomers(grp.getType());
            } else {
                System.out.println("Customers.findCustomers Error : No group type.");
                return null;
            }
        } else {
            System.out.println("Customers.findCustomers Error : No group.");
            return null;
        }
    }

    public void refresh(Groups groups) {
        if (groups != null) {
            for(int i = 0; i < this.count; ++i) {
                Customer cust = this.customers[i];
                cust.setGroup(groups.findGroupFor(cust));
            }

        }
    }

    public String toString() {
        String str = "";

        for(int i = 0; i < this.count; ++i) {
            str = str + this.customers[i].toString() + "\n";
        }

        return str;
    }
}
