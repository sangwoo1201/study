getStatistics(); //함수 호출
getEmp(1);//함수 호출

//사원 통계정보 불러오기
function getStatistics(){
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp/statistics',
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response); //결과 확인
            $('#studentsCnt').append(response.empCount); //사원 수
            $('#boardCnt').append(response.empSalAvg); //사원 급여 평균
            $('#writerCnt').append(response.deptCount); //부서 수
            $('#viewsCnt').append(response.empCommSum); //사원 보너스 총합
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
    var deptno = $('#i_deptno').val();
    //빈값 체크 로직 구현하기
    if(empno == ''){
        alert('사원번호를 입력하세요.');
        $('#i_empno').focus();
        return false;
    }
    if(ename == ''){
        alert('사원이름을 입력하세요.');
        $('#i_ename').focus();
        return false;
    }
    if(job == ''){
        alert('사원직책을 입력하세요.');
        $('#i_job').focus();
        return false;
    }
    if(sal == ''){
        alert('사원급여를 입력하세요.');
        $('#i_sal').focus();
        return false;
    }
    if(comm == ''){
        alert('사원보너스를 입력하세요.');
        $('#i_comm').focus();
        return false;
    }
    if(deptno == ''){
        alert('부서번호를 입력하세요.');
        $('#i_deptno').focus();
        return false;
    }
    var jsonData = { 
        "empno" : empno,
        "ename" : ename,
        "job" : job,
        "sal" : sal,
        "comm" : comm,
        "deptno" : deptno
    }; 
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            if(response > 0){
                alert("사원이 등록 되었습니다.");
                location.reload(); //자바스크립트에서 제공해주는 새로 고침
            }else{
                alert("사원번호가 이미 있습니다.😜");
            }
        }
    });
    
}

//전체 사원 조회하는 함수
function getEmp(pageNum){
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp?page='+pageNum,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            $('#empData').empty();
            $('.pagination').empty();
            console.log(response);
            var html = '';
            for(var i=0; i<response.list.length; i++){
                //사원 목록에 사원 데이터 *바인딩 (== 사원 목록 HTML에 데이터 보여주기)
                //tbody태그 id : empData에 바인딩 하기!
                html += '<tr onclick="getEmpByEmpno('+response.list[i].empno+')"><td>'+
                                                      response.list[i].empno+'</td><td>'+
                                                      response.list[i].ename+'</td><td>'+
                                                      response.list[i].job+'</td><td>'+
                                                      response.list[i].sal+'</td><td>'+
                                                      response.list[i].hiredate+'</td><td>'+
                                                      response.list[i].dname+'</td></tr>';
            }
            $('#empData').append(html);//table 바인딩 작업!
            var paginationHtml = '';
            if(response.hasPreviousPage){ //이전 버튼 여부 확인
                paginationHtml += '<a onclick="getEmp('+(pageNum-1)+')">Previous</a>';
            }
            for(var i=0; i< response.navigatepageNums.length; i++){ //총 보여줄 페이지
                var page = response.navigatepageNums[i];
                paginationHtml += '<a onclick="getEmp('+page+')">'+page+'</a>'
            }
            if(response.hasNextPage){ //다음 버튼 여부 확인
                paginationHtml += '<a onclick="getEmp('+(pageNum+1)+')">Next</a>';
            }
            $('.pagination').append(paginationHtml); //페이징 바인딩 작업!
        }
    });
}
//특정 사원 조회 함수
function getEmpByEmpno(empno){
    console.log('클릭한 사원번호는 ? '+empno);
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp/empno/'+empno,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response);
            $('.update-popup').css('display', 'block');
            $('#u_empno').val(response.empno); //데이터 바인딩!
            $('#u_ename').val(response.ename);
            $('#u_job').val(response.job);
            $('#u_sal').val(response.sal);
            $('#u_comm').val(response.comm);
            $('#u_deptno').val(response.deptno);
        }
    });
}

//사원 정보 수정(== 추가)
function updateEmp(){

    var empno = $('#u_empno').val();
    var ename = $('#u_ename').val();
    var job = $('#u_job').val();
    var sal = $('#u_sal').val();
    var comm = $('#u_comm').val();
    var deptno = $('#u_deptno').val();

    var jsonData = { 
        "empno" : empno,
        "ename" : ename,
        "job" : job,
        "sal" : sal,
        "comm" : comm,
        "deptno" : deptno
    }; 
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp',
        type : 'PATCH',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            if(response > 0){
                alert('수정 완료!');
                location.reload(); //자바스크립트에서 제공해주는 새로 고침
            }
        }
    });
}

//사원 삭제
//데이터는 곧 자산
//실제로 기업에서는 데이터를 삭제하지 않고, 삭제 여부 컬럼을 추가해서
//탈퇴한 회원은 Y 현재 회원은 N으로 관리 한다.
function fireEmp(){
    //update
    var empno = $('#u_empno').val();
    var ename = $('#u_ename').val();
    $.ajax({
        url: 'http://localhost:8080/api/v1/emp/empno/'+empno,
        type : 'PATCH',
        dataType : 'json',
        success : function(response){
            if(response > 0){
                alert(ename+'님 회원 탈퇴');
                location.reload(); //자바스크립트에서 제공해주는 새로 고침
            }
        }
    });
}
//엑셀 다운로드
function downloadExcelFile(){
    console.log('excel download 버튼 클릭');
    location.href = 'http://localhost:8080/excel/download';
}