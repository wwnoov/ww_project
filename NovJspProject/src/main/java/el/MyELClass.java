package el;

public class MyELClass {
  //주민 번호를 입력받아 성별을 반환합니다.
  public String getGender(String jumin) {
    String returnSTr = "";
    int beginIdx = jumin.indexOf("-") + 1;
    String genderStr = jumin.substring(beginIdx, beginIdx + 1);
    int genderInt = Integer.parseInt(genderStr);
    if (genderInt == 1 || genderInt == 3)
      returnSTr = "남자";
    else if (genderInt == 2 || genderInt == 4)
      returnSTr = "여자";
    else
      returnSTr = "주민등록 번호 오류입니다.";
    return returnSTr;
  }
  // 입력 받은 문자열이 숫자인지 판별해줍니다.
  public static boolean isNumber(String value){
    char[] chArr = value.toCharArray();
    for (int i = 0; i<chArr.length; i++){
      if (!(chArr[i] >= '0' && chArr[i]<= '9')){
        return false;
      }
    }
    return true;
  }

  //입력 받은 정수까지의 구구단을 HTML 테이블로 출력해줍니다,
  public static String showGugudan (int limiDan){
    StringBuffer sb = new StringBuffer();
    try {
      sb.append("<table border='1'>");
      for (int i =2 ; i<= limiDan; i++){
        sb.append("<tr>");
        for (int j=1 ; j<=9; j++){
          sb.append("<td>"+ i + "*" + j + "=" + (i*j)+"</td>");
        }
        sb.append("</tr>");
      }
      sb.append("</table>");
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return sb.toString();
  }
}
