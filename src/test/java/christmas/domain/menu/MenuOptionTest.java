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

}