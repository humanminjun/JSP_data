document.write("자바스크립트 스타트")

function loginCheck(){
	
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == ""){
	alert("암호는 반드시 입력해야 합니다.");
	frm.pwd.focus();
	return false;
	}
	return true;
}