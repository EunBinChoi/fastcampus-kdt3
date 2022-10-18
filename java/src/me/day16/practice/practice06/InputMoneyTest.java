package me.day16.practice.practice06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputMoneyTest {

    @Test
    public void inputMoneyTest_손님이_구매하기위해_넣은금액을_확인한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        int money = vm.getMoney();

        assertNotNull(money);
    }

    @Test
    public void inputMoneyTest_손님이_넣은_금액이_0이하일수없다() throws Exception {
        VendingMachine vm = new VendingMachine();
//      vm.setInputMoney(-1);
        vm.setInputMoney(1000);

        assertTrue(vm.getMoney() > 0, "투입 금액은 0이하 일수 없다");
    }


    @Test
    public void changeMoneyTest_손님이_선택한_물품의_가격을확인한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setSelectedProduct(650);

        assertEquals(650, vm.getSelectedProduct(), "손님이 선택한 물품 가격을 확인한다");
    }

    @Test
    public void changeMoneyTest_손님이_선택한_물품가격을_투입금액에서_차감한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        assertEquals(350, vm.getMoney(), "손님이 선택한 물품 가격을 투입 금액에서 차감한다");
    }

    @Test
    public void changeMoneyTest_손님에게_거스름돈을_반환한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        ChangeMoney cm = new ChangeMoney();
        cm.setChangeMoney(vm.getMoney());

        int[] money = cm.getChangeMoney();
        assertEquals(0, money[0], "손님에게 반환 할 500원의 개수");
        assertEquals(3, money[1], "손님에게 반환 할 100원의 개수");
        assertEquals(1, money[2], "손님에게 반환 할 50원의 개수");
        assertEquals(0, money[3], "손님에게 반환 할 10원의 개수");
    }
}
