package christmas.domain.menu;

import static christmas.domain.menu.MenuType.BEVERAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTypeTest {

    @DisplayName("메뉴명으로 메뉴가 해당하는 종류를 반환한다.")
    @Test
    void 메뉴_종류_찾기(){
        assertThat(MenuType.findMenuType("제로콜라")).isEqualTo(BEVERAGE);
    }

}