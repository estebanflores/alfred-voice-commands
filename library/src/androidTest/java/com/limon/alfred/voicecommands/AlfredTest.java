package com.limon.alfred.voicecommands;

import com.limon.alfred.voicecommands.action.Action;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class AlfredTest {

    @Mock
    private Action actionMock;

    @Before
    public void setup(){

    }

    @Test
    public void firstTest(){
        Alfred.rememberThisAction(actionMock);
    }
}