package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuGroupTest {

    @DisplayName("메뉴가 주어지면 메뉴의 종류를 반환한다.")
    @ParameterizedTest
    @CsvSource({"SEAFOOD_PASTA,MAIN_DISH", "TAPAS,APPETIZER", "CHAMPAGNE,BEVERAGE"})
    void 이름으로_메뉴_종류_찾기(String menuOption, String expected) {
        assertThat(MenuGroup.findMenuGroup(MenuOption.valueOf(menuOption))).isEqualTo(
                MenuGroup.valueOf(expected));
    }

}