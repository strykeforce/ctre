# CTRE Configs Checker

Help keep track of CTRE device configuration classes from season to season.

## Instructions

1. Update `vendordeps/Phoenix.json` to the version you want to check against.
2. Run unit tests with `gradlew test`.
3. Tests will fail if any fields are added to configuration classes or if the default values have changed.

You can also run the application with `gradlew run` to get a CSV list of all configuration fields.

## Classes Checked

These checks are up to date with the Phoenix 5.19.4 API.

![CTRE class diagram](ctre.png)

### TalonSRX Configuration

| Device Type           | Value                                     | Default                             |
| :-------------------- | :---------------------------------------- | :---------------------------------- |
| TalonSRXConfiguration | peakCurrentLimit                          | 1                                   |
| TalonSRXConfiguration | peakCurrentDuration                       | 1                                   |
| TalonSRXConfiguration | continuousCurrentLimit                    | 1                                   |
| TalonSRXConfiguration | primaryPID.selectedFeedbackSensor         | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | primaryPID.selectedFeedbackCoefficient    | 1                                   |
| TalonSRXConfiguration | auxiliaryPID.selectedFeedbackSensor       | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | auxiliaryPID.selectedFeedbackCoefficient  | 1                                   |
| TalonSRXConfiguration | forwardLimitSwitchSource                  | LimitSwitchSource.FeedbackConnector |
| TalonSRXConfiguration | reverseLimitSwitchSource                  | LimitSwitchSource.FeedbackConnector |
| TalonSRXConfiguration | forwardLimitSwitchDeviceID                | 0                                   |
| TalonSRXConfiguration | reverseLimitSwitchDeviceID                | 0                                   |
| TalonSRXConfiguration | forwardLimitSwitchNormal                  | LimitSwitchNormal.NormallyOpen      |
| TalonSRXConfiguration | reverseLimitSwitchNormal                  | LimitSwitchNormal.NormallyOpen      |
| TalonSRXConfiguration | sum0Term                                  | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | sum1Term                                  | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | diff0Term                                 | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | diff1Term                                 | FeedbackDevice.QuadEncoder          |
| TalonSRXConfiguration | openloopRamp                              | 0                                   |
| TalonSRXConfiguration | closedloopRamp                            | 0                                   |
| TalonSRXConfiguration | peakOutputForward                         | 1                                   |
| TalonSRXConfiguration | peakOutputReverse                         | -1                                  |
| TalonSRXConfiguration | nominalOutputForward                      | 0                                   |
| TalonSRXConfiguration | nominalOutputReverse                      | 0                                   |
| TalonSRXConfiguration | neutralDeadband                           | 0.04                                |
| TalonSRXConfiguration | voltageCompSaturation                     | 0                                   |
| TalonSRXConfiguration | voltageMeasurementFilter                  | 32                                  |
| TalonSRXConfiguration | velocityMeasurementPeriod                 | VelocityMeasPeriod.Period_100Ms     |
| TalonSRXConfiguration | velocityMeasurementWindow                 | 64                                  |
| TalonSRXConfiguration | forwardSoftLimitThreshold                 | 0                                   |
| TalonSRXConfiguration | reverseSoftLimitThreshold                 | 0                                   |
| TalonSRXConfiguration | forwardSoftLimitEnable                    | FALSE                               |
| TalonSRXConfiguration | reverseSoftLimitEnable                    | FALSE                               |
| TalonSRXConfiguration | slot0.kP                                  | 0                                   |
| TalonSRXConfiguration | slot0.kI                                  | 0                                   |
| TalonSRXConfiguration | slot0.kD                                  | 0                                   |
| TalonSRXConfiguration | slot0.kF                                  | 0                                   |
| TalonSRXConfiguration | slot0.integralZone                        | 0                                   |
| TalonSRXConfiguration | slot0.allowableClosedloopError            | 0                                   |
| TalonSRXConfiguration | slot0.maxIntegralAccumulator              | 0                                   |
| TalonSRXConfiguration | slot0.closedLoopPeakOutput                | 1                                   |
| TalonSRXConfiguration | slot0.closedLoopPeriod                    | 1                                   |
| TalonSRXConfiguration | slot1.kP                                  | 0                                   |
| TalonSRXConfiguration | slot1.kI                                  | 0                                   |
| TalonSRXConfiguration | slot1.kD                                  | 0                                   |
| TalonSRXConfiguration | slot1.kF                                  | 0                                   |
| TalonSRXConfiguration | slot1.integralZone                        | 0                                   |
| TalonSRXConfiguration | slot1.allowableClosedloopError            | 0                                   |
| TalonSRXConfiguration | slot1.maxIntegralAccumulator              | 0                                   |
| TalonSRXConfiguration | slot1.closedLoopPeakOutput                | 1                                   |
| TalonSRXConfiguration | slot1.closedLoopPeriod                    | 1                                   |
| TalonSRXConfiguration | slot2.kP                                  | 0                                   |
| TalonSRXConfiguration | slot2.kI                                  | 0                                   |
| TalonSRXConfiguration | slot2.kD                                  | 0                                   |
| TalonSRXConfiguration | slot2.kF                                  | 0                                   |
| TalonSRXConfiguration | slot2.integralZone                        | 0                                   |
| TalonSRXConfiguration | slot2.allowableClosedloopError            | 0                                   |
| TalonSRXConfiguration | slot2.maxIntegralAccumulator              | 0                                   |
| TalonSRXConfiguration | slot2.closedLoopPeakOutput                | 1                                   |
| TalonSRXConfiguration | slot2.closedLoopPeriod                    | 1                                   |
| TalonSRXConfiguration | slot3.kP                                  | 0                                   |
| TalonSRXConfiguration | slot3.kI                                  | 0                                   |
| TalonSRXConfiguration | slot3.kD                                  | 0                                   |
| TalonSRXConfiguration | slot3.kF                                  | 0                                   |
| TalonSRXConfiguration | slot3.integralZone                        | 0                                   |
| TalonSRXConfiguration | slot3.allowableClosedloopError            | 0                                   |
| TalonSRXConfiguration | slot3.maxIntegralAccumulator              | 0                                   |
| TalonSRXConfiguration | slot3.closedLoopPeakOutput                | 1                                   |
| TalonSRXConfiguration | slot3.closedLoopPeriod                    | 1                                   |
| TalonSRXConfiguration | auxPIDPolarity                            | FALSE                               |
| TalonSRXConfiguration | remoteFilter0.remoteSensorDeviceID        | 0                                   |
| TalonSRXConfiguration | remoteFilter0.remoteSensorSource          | RemoteSensorSource.Off              |
| TalonSRXConfiguration | remoteFilter1.remoteSensorDeviceID        | 0                                   |
| TalonSRXConfiguration | remoteFilter1.remoteSensorSource          | RemoteSensorSource.Off              |
| TalonSRXConfiguration | motionCruiseVelocity                      | 0                                   |
| TalonSRXConfiguration | motionAcceleration                        | 0                                   |
| TalonSRXConfiguration | motionCurveStrength                       | 0                                   |
| TalonSRXConfiguration | motionProfileTrajectoryPeriod             | 0                                   |
| TalonSRXConfiguration | feedbackNotContinuous                     | FALSE                               |
| TalonSRXConfiguration | remoteSensorClosedLoopDisableNeutralOnLOS | FALSE                               |
| TalonSRXConfiguration | clearPositionOnLimitF                     | FALSE                               |
| TalonSRXConfiguration | clearPositionOnLimitR                     | FALSE                               |
| TalonSRXConfiguration | clearPositionOnQuadIdx                    | FALSE                               |
| TalonSRXConfiguration | limitSwitchDisableNeutralOnLOS            | FALSE                               |
| TalonSRXConfiguration | softLimitDisableNeutralOnLOS              | FALSE                               |
| TalonSRXConfiguration | pulseWidthPeriod_EdgesPerRot              | 1                                   |
| TalonSRXConfiguration | pulseWidthPeriod_FilterWindowSz           | 1                                   |
| TalonSRXConfiguration | trajectoryInterpolationEnable             | TRUE                                |
