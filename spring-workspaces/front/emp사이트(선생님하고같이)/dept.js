getDept(1);

//전체 사원 조회하는 함수
function getDept(pageNum){
    $.ajax({
        url: 'http://localhost:8080/api/v1/dept?page='+pageNum,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            $('#deptData').empty();
            $('.pagination').empty();
            console.log(response);
            var html = '';
            for(var i=0; i<response.list.length; i++){
                //사원 목록에 사원 데이터 *바인딩 (== 사원 목록 HTML에 데이터 보여주기)
                //tbody태그 id : empData에 바인딩 하기!
                html += '<tr onclick="getDeptByDeptno('+response.list[i].deptno+')"><td>'+
                                                        response.list[i].deptno+'</td><td>'+
                                                        response.list[i].dname+'</td><td>'+
                                                        response.list[i].loc+'</td><td>'+
                                                        response.list[i].is_use+'</td></tr>';
            }
            $('#deptData').append(html);//table 바인딩 작업!
            var paginationHtml = '';
            if(response.hasPreviousPage){ //이전 버튼 여부 확인
                paginationHtml += '<a onclick="getDept('+(pageNum-1)+')">Previous</a>';
            }
            for(var i=0; i< response.navigatepageNums.length; i++){ //총 보여줄 페이지
                var page = response.navigatepageNums[i];
                paginationHtml += '<a onclick="getDept('+page+')">'+page+'</a>'
            }
            if(response.hasNextPage){ //다음 버튼 여부 확인
                paginationHtml += '<a onclick="getDept('+(pageNum+1)+')">Next</a>';
            }
            $('.pagination').append(paginationHtml); //페이징 바인딩 작업!
        }
    });
}
// 부서 추가
function setDept() {
    var deptno = $('#i_deptno').val();
    var dname = $('#i_dname').val();
    var loc = $('#i_loc').val();

    //빈값 체크 로직 구현하기
    if(deptno == ''){
        alert('부서 번호를 입력하세요.');
        $('#i_deptno').focus();
        return false;
    }
    if(dname == ''){
        alert('부서 이름을 입력하세요.');
        $('#i_dname').focus();
        return false;
    }
    if(loc == ''){
        alert('부서 지역을 입력하세요.');
        $('#i_loc').focus();
        return false;
    }
    var jsonData = {
        "deptno" : deptno,
        "dname" : dname,
        "loc" : loc
    }
    $.ajax({
        url : 'http://localhost:8080/api/v1/dept',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            if(response > 0){
                alert('부서가 등록 되었습니다.');
                location.reload(); //자바스크립트에서 제공해주는 새로 고침
            }else{
                alert('이미 등록된 부서입니다.')
            }
        }
    });
}
//특정 부서 조회 함수
function getDeptByDeptno(deptno){
    $.ajax({
        url: 'http://localhost:8080/api/v1/dept/deptno/'+deptno,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response);
            $('.update-popup').css('display', 'block');
            $('#u_deptno').val(response.deptno); //데이터 바인딩!
            $('#u_dname').val(response.dname);
            $('#u_loc').val(response.loc);
            $('#u_is_use').val(response.is_use);
        }
    });
}
//부서 정보 수정(== 추가)
function updateDept(){

    var deptno = $('#u_deptno').val();
    var dname = $('#u_dname').val();
    var loc = $('#u_loc').val();

    var jsonData = { 
        "deptno" : deptno,
        "dname" : dname,
        "loc" : loc
    }; 
    $.ajax({
        url: 'http://localhost:8080/api/v1/dept',
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
// 부서 삭제 (is_use사용)
function fireDept(){
    var deptno = $("#u_deptno").val();
    var dname = $("#u_dname").val();
    
    $.ajax({
    url: 'http://localhost:8080/api/v1/dept/deptno/'+deptno,
    type : 'DELETE',
    dataType : 'json',
    success : function(response){
         if(response > 0){
            alert(dname + '번 부서가 해체되었습니다.');
                 location.reload(); 
            }
        }
    });
}