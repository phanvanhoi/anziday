<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>

<body>
    <%@ include file="../master.page/left-panel.jsp"%>
    
    <div id="right-panel" class="right-panel">

        <%@ include file="../master.page/header-right-panel.jsp"%>
		<div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <strong>Normal</strong> Form
                            </div>
                            <div class="card-body card-block">
                                <form action="" method="post" class="">
                                    <div class="form-group"><label for="nf-email" class=" form-control-label">Email</label><input
                                            type="email" id="nf-email" name="nf-email" placeholder="Enter Email.."
                                            class="form-control"><span class="help-block">Please enter your email</span></div>
                                    <div class="form-group"><label for="nf-password" class=" form-control-label">Password</label><input
                                            type="password" id="nf-password" name="nf-password" placeholder="Enter Password.."
                                            class="form-control"><span class="help-block">Please enter your password</span></div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Submit
                                </button>
                                <button type="reset" class="btn btn-danger btn-sm">
                                    <i class="fa fa-ban"></i> Reset
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../master.page/footer.jsp"%>