getStatistics(); //함수 호출
getEmp(); //함수 호출

//사원 통계정보 불러오기
function getStatistics(){
    $.ajax({
        url : 'http://localhost:8080/api/v1/emp/statistics',
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response); //결과 확인
            $('#studentsCnt').append(response.empCount); //사원 수
            $('#boardCnt').append(response.empSalAvg); //사원 급여 평균
            $('#writerCnt').append(response.deptCount); //부서 수
            $('#viewsCnt').append(response.empCommSum); //보너스 합
        }
    });
}

//사원 추가
function setEmp(){
    var empno = $('#i_empno').val();
    var ename = $('#i_ename').val();
    var job = $('#i_job').val();
    var sal = $('#i_sal').val();
    var comm = $('#i_comm').val();
    //빈값 체크 로직 구현하기
    if(empno == ''){
        alert('사원 번호를 입력하세요.');
        $('#i_empno').focus();
        return false;
    }
    if(ename == ''){
        alert('이름을 입력하세요.');
        $('#i_ename').focus();
        return false;
    }
    if(job == ''){
        alert('담당 업무를 입력하세요.');
        $('#i_job').focus();
        return false;
    }
    if(sal == ''){
        alert('급여를 입력하세요.');
        $('#i_sal').focus();
        return false;
    }
    if(comm == ''){
        alert('보너스를 입력하세요.');
        $('#i_comm').focus();
        return false;
    }
    var jsonData = {
        "empno" : empno,
        "ename" : ename,
        "job" : job,
        "sal" : sal,
        "comm" : comm
    }
    $.ajax({
        url : 'http://localhost:8080/api/v1/emp',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            if(response > 0){
                alert('사원이 등록 되었습니다.');
                location.reload(); //자바스크립트에서 제공해주는 새로 고침
            }
        }
    });
}

//전체 사원 조회하는 함수
function getEmp(){
    $.ajax({
        url : 'http://localhost:8080/api/v1/emp',
        type : 'GET',
        dataType : 'json',
        success : function(response){
            //for문을 이용해서 배열 출력하기
            //배열하고 for문은 친구!!
            //response 배열!
            var html = '';
            for(var i=0; i<response.length; i++){
                //부서이름이 SALES인 사원만 출력하기!
                if(response[i].dname == 'SALES'){ //공부용 코드
                    //console.log(response[i]);
                }
                //사원 목록에 사원 데이터 *바인딩 (== 사원 목록 HTML에 데이터 보여주기)
                //tbody태그 id : empData에 바인딩 하기!
                html += '<tr onclick="getEmpByEmpno('+response[i].empno+')"><td>'+response[i].empno+'</td><td>'+response[i].ename+'</td><td>'+response[i].job+
                        '</td><td>'+response[i].sal+'</td><td>'+response[i].hiredate+'</td><td>'+response[i].dname+'</td></tr>';
            }
            $('#empData').append(html);//바인딩 작업!
        }
    });
}

//특정 사원 조회 함수
function getEmpByEmpno(empno){
    console.log('클릭한 사원번호는 ? '+empno);
    $.ajax({
        url : 'http://localhost:8080/api/v1/emp/empno/'+empno,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response);
            $('.update-popup').css('display', 'block');
            $('#u_empno').val(response.empno);
            $('#u_ename').val(response.ename);
            $('#u_job').val(response.job);
            $('#u_sal').val(response.sal);
            $('#u_comm').val(response.comm);
        }
    });
}