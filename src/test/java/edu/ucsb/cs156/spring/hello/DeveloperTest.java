package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f26-teams>
        assertEquals("Shivansh G.", Developer.getName());
    }

@Test
public void getGithubId_returns_correct_githubId() {
    assertEquals("DeadshotLegend", Developer.getGithubId());
}    // 100% mutation coverage (all mutants timed out or killed)


@Test
public void getTeam_returns_team_with_correct_name() {
    Team t = Developer.getTeam();
    assertEquals("f26-10", t.getName());
}

@Test
public void getTeam_returns_team_with_correct_members() {
    Team t = Developer.getTeam();
    assertTrue(t.getMembers().contains("Ataman"), "Team should contain Ataman");
    assertTrue(t.getMembers().contains("Cris"), "Team should contain Cris");
    assertTrue(t.getMembers().contains("Nathan"), "Team should contain Nathan");
    assertTrue(t.getMembers().contains("Yongxin"), "Team should contain Yongxin");
    assertTrue(t.getMembers().contains("Zhewen"), "Team should contain Zhewen");

}
}
