$(function () {
    fetch('/register/getOrgInfo')
        .then(function(response) {
            return response.json();
        })
        .then(function(myJson) {
            let orgType = $("#orgType");
            orgType.append(new Option("-----请选择-----",'UnSelected'));
            $.each(myJson, function (index, type) {
                const option = new Option(type.orgName,type.itemcode);
                orgType.append(option);
            });
        });
});

function sendVerifyCode(){
    let b = validateEmail();
    if(b){
        let email = $("#email").val();
        let button = $("#button-varyCode-border");
        settime(button);
        $.ajax({
            type:"Post",//请求类型
            url:"/register/verify?email="+email,//请求的url
            // data:{name:$(".name").val()},//请求参数
            dataType:"text",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data == "success"){

                } else {
                    swal({
                        title: "发送失败",
                        text: "很遗憾，验证码发送失败，请重新点击发送",
                        type: "error"
                    });
                    countdown = 0;
                }
            },
            error:function(data){
                swal({
                    title: "未知错误",
                    text: "发生未知错误，请联系管理员！",
                    type: "error"
                });
            }
        });
    }

}
var countdown = 60;
function settime(object){
    if (countdown == 0) {
        object.removeAttr("disabled");
        object.html("发送验证码");
        countdown = 60;
        return;
    } else {
        object.attr("disabled");
        object.html("重新发送(" + countdown + ")");
        countdown--;
    }
    setTimeout(function () {
        settime(object)
    },1000);
}

function submit(){
    let nullFlag = checkNull();
    if(nullFlag){
        //用户名验证无重复才可注册
            let creditCodeFlag = validateCreditCode();
            if(creditCodeFlag){
                let passwordFlag = validatePassword();
                if(passwordFlag){
                    let password = $("#password").val();
                    let certainPassword = $("#certainPassword").val();
                    if(password == certainPassword){
                        let emailFlag = validateEmail();
                        if(emailFlag){
                            let phoneFlag = validateMobilePhone();
                            if(phoneFlag){
                                validateVerifyCode();
                            }
                        }
                    } else {
                        swal({
                            title: "密码不一致",
                            text: "您的密码不一致，请重新填写",
                            type: "error"
                        });
                    }
                }
            }

    }
}

function checkNull() {
    if( $("#orgName").val() == null || $("#orgName").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的企业名称为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#orgType").find('option:selected').val() == "UnSelected" ){
        swal({
            title: "存在未选择的下拉框",
            text: "您未对机构类型进行选择，请选择",
            type: "error"
        });
        return false;
    }
    else if( $("#orgCode").val() == null || $("#orgCode").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的统一社会信用代码为空，请填写",
            type: "error"
        });
    }
    else if( $("#name").val() == null || $("#name").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的用户名为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#password").val() == null || $("#password").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的密码为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#certainPassword").val() == null || $("#certainPassword").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的确认密码为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#mobilephone").val() == null || $("#mobilephone").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的电话号为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#email").val() == null || $("#email").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的邮箱为空，请填写",
            type: "error"
        });
        return false;
    }
    else if( $("#input-varyCode-border").val() == null || $("#input-varyCode-border").val().trim() == ''){
        swal({
            title: "存在未填写的文本框",
            text: "您的验证码为空，请填写",
            type: "error"
        });
        return false;
    }
    return true;
}

//验证统一社会信用代码
function validateCreditCode(){
    let patt = /\d{18}$/;
    if(!patt.test($("#orgCode").val())){
        swal({
            title: "格式有误",
            text: "您的统一社会信用代码格式有误，请检查后重新填写",
            type: "error"
        });
        return false;
    } else
        return true;
}

//验证密码位数
function validatePassword(){
    if (($("#password").val().length < 6)) {
        swal({
            title: "格式有误",
            text: "您的密码太短，请填写不小于六位数的密码",
            type: "error"
        });
        return false;
    } else
        return true;
}

//验证电话号
function validateMobilePhone(){
    let patt = /^1(3|4|5|6|7|8|9)\d{9}$/;
    if(!patt.test($("#mobilephone").val())){
        swal({
            title: "格式有误",
            text: "您的手机号格式有误，请检查后重新填写",
            type: "error"
        });
        return false;
    } else
        return true;
}

//验证邮箱
function validateEmail(){
    let patt = /^\w+@\w+(\.\w+)+$/;
    if(!patt.test($("#email").val())){
        swal({
            title: "格式有误",
            text: "您的邮箱格式有误，请检查您的邮箱格式后重新点击发送",
            type: "error"
        });
        return false;
    } else
        return true;
}

//验证验证码
function validateVerifyCode() {
    let verifyCode = $("#input-varyCode-border").val();
    let email = $("#email").val();
    $.ajax({
        type:"Post",//请求类型
        url:"/register/verifyCode?email="+email+"&verifyCode="+verifyCode,//请求的url
        // data:{name:$(".name").val()},//请求参数
        dataType:"text",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            console.log(data);
            if(data == "success"){
                swal({
                    title: "恭喜！",
                    text: "恭喜您注册成功",
                    type: "success",
                    button:"确定"
                },function () {
                    // window.location.href = "../../../../register";
                    $("#registerForm").attr("action","/register");
                    $("#registerForm").submit();
                });
            } else {
                swal({
                    title: "验证码有误",
                    text: "您的验证码有误，请检查后重新填写",
                    type: "error"
                });
            }
        },
        error:function(data){
            swal({
                title: "未知错误",
                text: "发生未知错误，请联系管理员！",
                type: "error"
            });
        }
    });
}



//验证用户名
function userNameCheck(){
    console.log("aaaaaaaaaaaaaaa");
    let name = $("#name").val();
    $.ajax({
        type:"Post",//请求类型
        url:"/register/verifyUserName?username="+name,//请求的url
        dataType:"text",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            console.log(data);
            if(data == "success"){

            } else {
                swal({
                    title: "请重新填写用户名",
                    text: "用户名已被注册！请您重新填写",
                    type: "error"
                });
            }
        },
        error:function(data){
            swal({
                title: "未知错误",
                text: "发生未知错误，请联系管理员！",
                type: "error"
            });
        }
    });
}