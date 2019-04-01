package hu.bme.mit.train.sensor;


import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUser mockTUI;
    TrainController mockTC;
    TrainSensorImpl tsi;

    @Before
    public void before() {
        mockTUI = mock(TrainUserImpl.class);
        mockTC = mock(TrainController.class);
        tsi =  new TrainSensorImpl(mockTC, mockTUI);
    }

    @Test
    public void TestTooLow() {
        mockTUI.setAlarmState(false);
        mockTC.setSpeedLimit(600);
        tsi.overrideSpeedLimit(-5);
        verify(mockTUI).setAlarmState(true);
        //when(mockTUI.getAlarmState()).thenReturn(true);
    }
    @Test
    public void TestTooHigh() {
        mockTUI.setAlarmState(false);
        mockTC.setSpeedLimit(600);
        tsi.overrideSpeedLimit(505);
        verify(mockTUI).setAlarmState(true);
        //when(mockTUI.getAlarmState()).thenReturn(true);
    }
    @Test
    public void TestBetween() {
        mockTUI.setAlarmState(false);
        mockTC.setSpeedLimit(260);
        tsi.overrideSpeedLimit(255);
        verify(mockTUI).setAlarmState(false);
        //when(mockTUI.getAlarmState()).thenReturn(false);
    }
    @Test
    public void TestHigherRelative() {
        mockTUI.setAlarmState(false);
        mockTC.setSpeedLimit(200);
        mockTC.setJoystickPosition(200);
        tsi.overrideSpeedLimit(102);
        verify(mockTUI).setAlarmState(false);
        //when(mockTUI.getAlarmState()).thenReturn(false);
    }
    @Test
    public void TestLowerRelative() {
        mockTUI.setAlarmState(false);
        mockTC.setSpeedLimit(200);
        mockTC.setJoystickPosition(200);
        tsi.overrideSpeedLimit(98);
        verify(mockTUI).setAlarmState(false);
        //when(mockTUI.getAlarmState()).thenReturn(true);
    }
}
