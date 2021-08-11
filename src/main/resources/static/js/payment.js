


function payment(totalPay, lastP, userInfo) {
	
	
	
	console.log(totalPay);
	
 var IMP = window.IMP;
        IMP.init('imp75081675'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        IMP.request_pay({
            pg : 'html5_inicis',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : lastP,
            amount : totalPay,
            buyer_email : userInfo.userEmail,
            buyer_name : userInfo.userName,
            buyer_tel : userInfo.userPhone,
            buyer_addr : userInfo.userAddress2,
            buyer_postcode : userInfo.userAddress1
        }, function(rsp) {
           if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }

            alert(msg);
        });
};

