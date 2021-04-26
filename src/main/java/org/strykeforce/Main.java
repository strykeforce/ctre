package org.strykeforce;

import com.ctre.phoenix.motorcontrol.can.BaseMotorControllerConfiguration;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.BaseTalonPIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.can.FilterConfiguration;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class Main {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    var fields = TalonSRXConfiguration.class.getDeclaredFields();
    var talonSRXConfiguration = new TalonSRXConfiguration();

    for (var field : fields) {
      String name = field.getName();
      Object value = talonSRXConfiguration.getClass().getField(name).get(talonSRXConfiguration);
      System.out.println("TalonSRXConfiguration," + name + "," + value);
    }

    fields = BaseTalonConfiguration.class.getDeclaredFields();
    for (var field : fields) {
      String name = field.getName();
      Object value = talonSRXConfiguration.getClass().getField(name).get(talonSRXConfiguration);
      if (value.getClass().getTypeName().equals(BaseTalonPIDSetConfiguration.class.getTypeName())) {
        var pidConf = (BaseTalonPIDSetConfiguration) value;
        System.out.println("TalonSRXConfiguration," + name + ".selectedFeedbackSensor,"
            + pidConf.selectedFeedbackSensor);
        System.out.println("TalonSRXConfiguration," + name + ".selectedFeedbackCoefficient,"
            + pidConf.selectedFeedbackCoefficient);
      } else {
        System.out.println("TalonSRXConfiguration," + name + "," + value);
      }
    }

    fields = BaseMotorControllerConfiguration.class.getDeclaredFields();
    for (var field : fields) {
      String name = field.getName();
      Object value = talonSRXConfiguration.getClass().getField(name).get(talonSRXConfiguration);
      if (value.getClass().getTypeName().equals(SlotConfiguration.class.getTypeName())) {
        var slotConf = (SlotConfiguration) value;
        var pidFields = SlotConfiguration.class.getDeclaredFields();
        for (var pidField : pidFields) {
          Object pidValue = pidField.get(slotConf);
          System.out
              .println("TalonSRXConfiguration," + name + "." + pidField.getName() + "," + pidValue);

        }
      } else if (value.getClass().getTypeName().equals(FilterConfiguration.class.getTypeName())) {
        var filterConf = (FilterConfiguration) value;
        var filterFields = FilterConfiguration.class.getDeclaredFields();
        for (var filterField : filterFields) {
          Object filterValue = filterField.get(filterConf);
          System.out
              .println("TalonSRXConfiguration," + name + "." + filterField.getName() + ","
                  + filterValue);
        }
      } else {
        System.out.println("TalonSRXConfiguration," + name + "," + value);
      }
    }

  }
}
