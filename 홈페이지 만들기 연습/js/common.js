   function checkValue(obj, msg){    //자바스크립트는 타입이 필요없다. score.kor_1이 곧 obj라는 말 , v에는 국어점수가 들어간다
                        //ovj에는 score.kor_1이 들어있다. 그래서 이것을 불러낼 때 일일히 score.kor_1 부르지 않고 obj. 이런식으로 부름
      var objvalue = obj.value;
      var tf = false;

      if (objvalue == "") {
            alert(msg+"입력하세요!");
            obj.focus();
            //score.kor_1.focus();
            return true;                  //값을 잘못입력하면 true 출력 제대로 되면 맨 밑 false 감.
         } else {
            //if (kor >100{
            if (Number(objvalue) > 100) {
               alert("점수 100점 이하");
               obj.focus();
            //   score.kor_1.focus();
               return true;
            }
            if (Number(objvalue) < 0) {
               alert("점수 0점 이상");
               obj.focus();
               //score.kor_1.focus();
               return true;
            }

            }
            return false;
      //   alert("국어:"+objvalue+"점");   }
         }
