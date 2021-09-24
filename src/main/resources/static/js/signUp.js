	var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
    //년도 selectbox만들기               
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '년</option>');    
    }

    // 월별 selectbox 만들기            
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
    }
    
    // 일별 selectbox 만들기
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="' + dd + '">' + dd+ '일</option>');    
    }
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true");       
    
	

  	$('#chk_agree').change(function(){
  		/* console.log('AA'); */
		var checked = $('#chk_agree').is(':checked');
		
		if(checked)
			btn_on();
		else
			btn_off();
		});
	
		var btn;
		 //버튼활성화
		 function btn_on() {
		  btn = document.getElementById('goInsert');
		  btn.disabled = false;
		 }
		 
		 //버튼비활성화
		 function btn_off() {
		  btn = document.getElementById('goInsert');
		  btn.disabled = 'disabled';
		 }

	
		 
		 function Checkform() {
		    if( frm.userId.value == "" ) {
		    	frm.userId.focus();
		    	alert("아이디를 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.userPassword.value == "" ) {
		    	frm.userPassword.focus();
		    	alert("비밀번호를 입력해 주십시오.");
		    	 return false;
		    }
		    
		    if(frm.passwordConfirm.value == ''){
		    	frm.passwordConfirm.focus();
				alert('비밀번호 확인을 입력하세요');
				return false;
			}
		    
		    if(frm.userPassword.value != frm.passwordConfirm.value){
		   		 frm.userPassword.focus();
				alert('비밀번호와 비밀번호 확인이 다릅니다');	
				 return false;
		    }
		   
		    if( frm.userName.value == "" ) {
		    	frm.userName.focus();
		    	alert("이름을 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.phone1.value == "" ) {
		    	frm.phone1.focus();
		    	alert("휴대전화번호를 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.phone2.value == "" ) {
		    	frm.phone2.focus();
		    	alert("휴대전화번호를 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.phone3.value == "" ) {
		    	frm.phone3.focus();
		    	alert("휴대전화번호를 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.userEmail.value == "" ) {
		    	frm.userEmail.focus();
		    	alert("이메일을 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( $('input:radio[name=userGender]').is(':checked') == false) {
			    	alert("성별을 입력해 주십시오.");
			    	 return false;
			 }
		   
		   
		    if( frm.userAddress1.value == "" ) {
		    	frm.userAddress1.focus();
		    	alert("우편번호를 입력해 주십시오.");
		    	 return false;
		    }
		    
		    if( frm.userAddress2.value == "" ) {
		    	frm.userAddress2.focus();
		    	alert("도로명주소를 입력해 주십시오.");
		    	 return false;
		    }
		   
		    if( frm.userAddress3.value == "" ) {
		    	frm.userAddress3.focus();
		    	alert("상세주소를 입력해 주십시오.");
		    	 return false;
		    }
		    

	     	
		    
 				// 공백제거 끝
	     	 
	     	 //  폰넘버
    		var phoneNumber = $("#phone1").val() +"-"+ $("#phone2").val() + "-"+ $("#phone3").val();
         
     			$("#userPhone").val(phoneNumber);
     	
   		  	//생일
     		var birthDate = $("#year").val() +"/"+ $("#month").val() + "/"+ $("#day").val();
     	
     			$("#userBirth").val(birthDate);
	     	 
	     	 
	     	 
			//유효성 검사	
		    
		    var pw = $("#userPassword").val();
			var id = $("#userId").val();
		    var checkNumber = pw.search(/[0-9]/g);
		    var checkEnglish = pw.search(/[a-z]/ig);
		 
		    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(pw)){       
		    	frm.userPassword.focus();     
		        alert('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
		        return false;
		    }else if(checkNumber <0 || checkEnglish <0){
		    	frm.userPassword.focus();
		        alert("숫자와 영문자를 혼용하여야 합니다.");
		        return false;
		    }else if(/(\w)\1\1\1/.test(pw)){
		    	frm.userPassword.focus();
		        alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
		        return false;
		    }else if(pw.search(id) > -1){
		   		frm.userPassword.focus();
		        alert("비밀번호에 아이디가 포함되어 있습니다.");
		        return false;
		    }else {

			console.log("통과");
			
			}
		    
		    
		    var ph = $("#userPhone").val();
		    var checkEnglishph = ph.search(/[a-z]/ig);
		    var check_kor = ph.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/ig);

		    if( checkEnglishph >0 || check_kor>0 ){
		   		 frm.phone2.focus();
		        alert("숫자만 입력가능합니다.");
		        return false;
		    }
		    
		    
		    
		    
		 }


		
		 function fn_idChk(){
				$.ajax({
					url : "/idChk",
					type : "POST",
					dataType : "text",
					
					data : {"userId" : $("#userId").val()},
					success : function(data){
						
						if(data == "exist"){
							alert("중복된 아이디입니다.");
						}else if(data == "usable"){
							alert("사용가능한 아이디입니다.");
							$("#idChk").attr("value", "Y");
						}
					},error: function(err){
						console.log(err);
					}
				})
			}

		 		 
			var pop;

			function goPopup() {
				// window.name = "부모창 이름"; 
				window.name = "parentForm";

				//pop = window.open("/resources/kit/jusoPopup2.html", "pop","width=570, height=420, scrollbars=yes");
				pop = window.open("/jusoPopup.html", "pop",
						"width=570, height=420, scrollbars=yes");

			}

			function jusoCallBack(entX, entY) {
				var form = $('<form></form>');
				form.attr('action', '/map');
				form.attr('method', 'post');
				form.appendTo('body');
				form.append($('<input type="hidden" value="' + entX + '" name=entX>'));
				form.append($('<input type="hidden" value="' + entY + '" name=entY>'));
				form.submit();

				pop.close();
			}