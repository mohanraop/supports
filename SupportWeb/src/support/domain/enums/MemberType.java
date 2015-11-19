package support.domain.enums;

import java.util.HashMap;
import java.util.Map;


public enum MemberType {
  TRAINER("02", "Trainer"),
  TRAINEE("03","Trainee");

  private String code;
  private String description;
  
  private MemberType(String code, String description) {
    this.setCode(code);
    this.setDescription(description);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  private static Map<String, MemberType> memberTypes = new HashMap<String, MemberType>();
  
  static {
    for (MemberType memberType : MemberType.values()) {
      memberTypes.put(memberType.getCode(), memberType);
    }
  }

  public static MemberType getMemberTypeForCode(String code) {
    return memberTypes.get(code);
  }
}
