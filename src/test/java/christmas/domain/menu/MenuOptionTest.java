package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuOptionTest {

    @DisplayName("해당 메뉴의 종류를 찾는다.")
    @ParameterizedTest
    @CsvSource({"CHOCO_CAKE,DESSERT", "T_BONE_STEAK,MAIN_DISH"})
    void 메뉴_종류_찾기(String menuOption, String expected) {
        assertThat(MenuOption.valueOf(menuOption).isGroupOf()).isEqualTo(
                MenuGroup.valueOf(expected));
    }

    @DisplayName("메뉴 이름으로 메뉴를 찾는다.")
    @ParameterizedTest
    @CsvSource({"시저샐러드,CAESAR_SALAD", "티본스테이크,T_BONE_STEAK", "레드와인,RED_WINE", "없는메뉴,NONE"})
    void 메뉴_찾기(String viewName, String expected) {
        assertThat(MenuOption.findMenuOption(viewName)).isEqualTo(
                MenuOption.valueOf(expected));
    }

}