function getParameterValues(){
	var name = "name=" + encodeURIComponent(document.getElementById("name").value);
	var kor = "kor=" + document.getElementById("kor").value;
	var eng = "eng=" + document.getElementById("eng").value;
	var math = "math=" + document.getElementById("math").value;
	
	return "?" + name + "&" + kor + "&" + eng + "&" + math;
}


function load(){
	var url = "score.do" + getParameterValues();
	
	httpRequest = new XMLHttpRequest();					// server와 통신하는 것을 도와주는 객체
	httpRequest.onreadystatechange=callback;			// 처리할 함수
	httpRequest.open("GET", url, true);					// true : 비동기 / false : 동기
	httpRequest.send();									// get : send() / post : send("data")
}

function callback(){
	alert("readystate : " + httpRequest.readyState);
	// readyState == 4 : 통신 완료되었다면
	if(httpRequest.readyState == 4){
		alert("status : " + httpRequest.status);
		// 통신이 성공적으로 완료되었다면
		if(httpRequest.status == 200){
			
			// responseText : 요청 후 응답받은 문자열
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) + "의 총점 : " + obj.sum +
			"\n평균 : " + obj.avg;
		} else {
			alert("통신 실패");
		}
	}
	
}

/*
	XMLHttpRequest : javascript object. http를 통한 데이터 송수신 지원
	
	<onreadystatechange>
	- readystate
	  0: uninitialized - 실행(load)되지 않음
	  1: loading - 로드 중
	  2: loaded - 로드 됨
	  3: interactive - 통신됨
	  4: complete - 통신 완료
	- status
	  200 : 성공
	  400 : bad request
	  401 : unauthorized
	  403 : forbidden
	  404 : not found
	  415 : unsupported media type
	  500 : internal server error



	**
	encodeURIComponent : 모든 문자를 인코딩(UTF-8)
	decodeURIComponent : UTF-8 에서 다시 원래 글자로.
	encodeURI : 주소줄에서 사용되는 특수문자는 제외하고 인코딩
	JSON.parse : json형태의 문자열을 json객체로 변화 (string -> json object)
	JSON.stringify : javascript 객체(json 형태로 변환할 수 있는)를 json 형태의 문자열로 반환(object -> json string)




*/