package christmas.domain.menu;

import static christmas.domain.menu.MenuOption.NO_MENU;
import static christmas.domain.menu.MenuOption.TAPAS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuOptionTest {

    @DisplayName("존재하지 않는 메뉴일 경우 NONE을 반환한다.")
    @Test
    void 없는_메뉴() {
        assertThat(MenuOption.findMenuOption("없는 메뉴")).isEqualTo(NO_MENU);
    }

    @DisplayName("메뉴 이름에 맞는 enum을 반환한다.")
    @Test
    void 메뉴_찾기_성공() {
        //given
        String viewName = "타파스";

        //when
        MenuOption menuOption = MenuOption.findMenuOption(viewName);

        //then
        assertThat(menuOption).isEqualTo(TAPAS);
    }

}
