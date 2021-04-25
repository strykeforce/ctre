package org.strykeforce;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
import com.ctre.phoenix.motorcontrol.can.BaseMotorControllerConfiguration;
import com.ctre.phoenix.motorcontrol.can.BasePIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.BaseTalonPIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.can.FilterConfiguration;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Checks against Phoenix 5.19.4 API (April 2021)
 */
class TalonConfigTest {

  @Test
  @DisplayName("Verify TalonSRXConfiguration fields")
  void verifyTalonSrxConfigurationFields() {
    assertEquals(3, TalonSRXConfiguration.class.getDeclaredFields().length);
  }

  @Test
  @DisplayName("Verify TalonFXConfiguration fields")
  void verifyTalonFXConfigurationFields() {
    assertEquals(6, TalonFXConfiguration.class.getDeclaredFields().length);
    assertEquals(4, SupplyCurrentLimitConfiguration.class.getDeclaredFields().length);
    assertEquals(4, StatorCurrentLimitConfiguration.class.getDeclaredFields().length);
  }

  @Test
  @DisplayName("Verify BaseTalonConfiguration fields")
  void verifyBaseTalonConfigurationFields() {
    assertEquals(12, BaseTalonConfiguration.class.getDeclaredFields().length);
    assertEquals(1, BaseTalonPIDSetConfiguration.class.getDeclaredFields().length);
    assertEquals(1, BasePIDSetConfiguration.class.getDeclaredFields().length);
  }

  @Test
  @DisplayName("Verify BaseMotorControllerConfiguration fields")
  void verifyBaseMotorControllerConfigurationFields() {
    assertEquals(36, BaseMotorControllerConfiguration.class.getDeclaredFields().length);
    assertEquals(9, SlotConfiguration.class.getDeclaredFields().length);
    assertEquals(2, FilterConfiguration.class.getDeclaredFields().length);
  }

  @Test
  @DisplayName("Verify TalonSRXConfiguration defaults")
  void verifyTalonSrxConfigurationDefaults() {
    var conf = new TalonSRXConfiguration();

    assertEquals(1, conf.peakCurrentLimit);
    assertEquals(1, conf.peakCurrentDuration);
    assertEquals(1, conf.continuousCurrentLimit);

    assertEquals(FeedbackDevice.QuadEncoder, conf.primaryPID.selectedFeedbackSensor);
    assertEquals(FeedbackDevice.QuadEncoder, conf.auxiliaryPID.selectedFeedbackSensor);
  }

  @Test
  @DisplayName("Verify TalonFXConfiguration defaults")
  void verifyTalonFxConfigurationDefaults() {
    var conf = new TalonFXConfiguration();

    assertFalse(conf.supplyCurrLimit.enable);
    assertEquals(0.0, conf.supplyCurrLimit.currentLimit);
    assertEquals(0.0, conf.supplyCurrLimit.triggerThresholdCurrent);
    assertEquals(0.0, conf.supplyCurrLimit.triggerThresholdTime);

    assertFalse(conf.statorCurrLimit.enable);
    assertEquals(0.0, conf.statorCurrLimit.currentLimit);
    assertEquals(0.0, conf.statorCurrLimit.triggerThresholdCurrent);
    assertEquals(0.0, conf.statorCurrLimit.triggerThresholdTime);

    assertEquals(FeedbackDevice.IntegratedSensor, conf.primaryPID.selectedFeedbackSensor);
    assertEquals(FeedbackDevice.IntegratedSensor, conf.auxiliaryPID.selectedFeedbackSensor);
  }

  @Test
  @DisplayName("Verify BaseTalonConfiguration defaults")
  void verifyBaseTalonConfigurationDefaults() {
    var conf = new BaseTalonConfiguration(FeedbackDevice.QuadEncoder);

    assertEquals(FeedbackDevice.QuadEncoder, conf.primaryPID.selectedFeedbackSensor);
    assertEquals(FeedbackDevice.QuadEncoder, conf.auxiliaryPID.selectedFeedbackSensor);
    assertEquals(1.0, conf.primaryPID.selectedFeedbackCoefficient);
    assertEquals(1.0, conf.auxiliaryPID.selectedFeedbackCoefficient);

    assertEquals(LimitSwitchSource.FeedbackConnector, conf.forwardLimitSwitchSource);
    assertEquals(0, conf.forwardLimitSwitchDeviceID);
    assertEquals(LimitSwitchNormal.NormallyOpen, conf.forwardLimitSwitchNormal);
    assertEquals(LimitSwitchSource.FeedbackConnector, conf.reverseLimitSwitchSource);
    assertEquals(0, conf.reverseLimitSwitchDeviceID);
    assertEquals(LimitSwitchNormal.NormallyOpen, conf.reverseLimitSwitchNormal);

    assertEquals(FeedbackDevice.QuadEncoder, conf.sum0Term);
    assertEquals(FeedbackDevice.QuadEncoder, conf.sum1Term);
    assertEquals(FeedbackDevice.QuadEncoder, conf.diff0Term);
    assertEquals(FeedbackDevice.QuadEncoder, conf.diff1Term);
  }

  @Test
  @DisplayName("Verify BaseMotorControllerConfiguration defaults")
  void verifyBaseMotorControllerConfigurationDefaults() {
    var conf = new BaseMotorControllerConfiguration() {
    };

    assertEquals(0.0, conf.openloopRamp);
    assertEquals(0.0, conf.closedloopRamp);
    assertEquals(1.0, conf.peakOutputForward);
    assertEquals(-1.0, conf.peakOutputReverse);
    assertEquals(0.0, conf.nominalOutputForward);
    assertEquals(0.0, conf.nominalOutputReverse);
    assertEquals(0.04, conf.neutralDeadband);
    assertEquals(0.0, conf.voltageCompSaturation);
    assertEquals(32, conf.voltageMeasurementFilter);
    assertEquals(VelocityMeasPeriod.Period_100Ms, conf.velocityMeasurementPeriod);
    assertEquals(64, conf.velocityMeasurementWindow);
    assertEquals(0.0, conf.forwardSoftLimitThreshold);
    assertFalse(conf.forwardSoftLimitEnable);
    assertEquals(0.0, conf.reverseSoftLimitThreshold);
    assertFalse(conf.reverseSoftLimitEnable);

    assertEquals(0.0, conf.slot0.kP);
    assertEquals(0.0, conf.slot0.kI);
    assertEquals(0.0, conf.slot0.kD);
    assertEquals(0.0, conf.slot0.kF);
    assertEquals(0.0, conf.slot0.integralZone);
    assertEquals(0.0, conf.slot0.maxIntegralAccumulator);
    assertEquals(1.0, conf.slot0.closedLoopPeakOutput);
    assertEquals(1, conf.slot0.closedLoopPeriod);
    assertEquals(0.0, conf.slot0.allowableClosedloopError);

    assertFalse(conf.auxPIDPolarity);

    assertEquals(RemoteSensorSource.Off, conf.remoteFilter0.remoteSensorSource);
    assertEquals(0, conf.remoteFilter0.remoteSensorDeviceID);
    assertEquals(RemoteSensorSource.Off, conf.remoteFilter1.remoteSensorSource);
    assertEquals(0, conf.remoteFilter1.remoteSensorDeviceID);

    assertEquals(0.0, conf.motionCruiseVelocity);
    assertEquals(0.0, conf.motionAcceleration);
    assertEquals(0, conf.motionCurveStrength);
    assertEquals(0, conf.motionProfileTrajectoryPeriod);

    assertFalse(conf.feedbackNotContinuous);
    assertFalse(conf.remoteSensorClosedLoopDisableNeutralOnLOS);
    assertFalse(conf.clearPositionOnLimitF);
    assertFalse(conf.clearPositionOnLimitR);
    assertFalse(conf.clearPositionOnQuadIdx);
    assertFalse(conf.limitSwitchDisableNeutralOnLOS);
    assertFalse(conf.softLimitDisableNeutralOnLOS);

    assertEquals(1, conf.pulseWidthPeriod_EdgesPerRot);
    assertEquals(1, conf.pulseWidthPeriod_FilterWindowSz);
    assertTrue(conf.trajectoryInterpolationEnable);
  }
}
