<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/function.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/commonUI.css">
<script type="text/javascript" src="js/move.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    function hasClass(el, className) {
        if (el.classList)
            return el.classList.contains(className)
        else
            return !!el.className.match(new RegExp('(\\s|^)' + className + '(\\s|$)'))
    }

    function addClass(el, className) {
        if (el.classList)
            el.classList.add(className)
        else if (!hasClass(el, className)) el.className += " " + className
    }

    function removeClass(el, className) {
        if (el.classList)
            el.classList.remove(className)
        else if (hasClass(el, className)) {
            var reg = new RegExp('(\\s|^)' + className + '(\\s|$)')
            el.className = el.className.replace(reg, ' ')
        }
    }
    window.onload = function() {
        var oDetailDrop = document.getElementById('user-dropdown');
        var oUserLogout = document.getElementById('user-logout');
        var oMenuDrop = document.getElementById('menu-dropdown');
        var oMenu = document.getElementById('sidebar');
        var aFirMenu = document.getElementsByClassName('fir-menu');
        var aFirMenuText = document.getElementsByClassName('fir-menu-text');
        var oContent = document.getElementsByClassName('g-content')[0];
        var i = 0;

        oDetailDrop.onclick = function() {
            startMove(oUserLogout, {
                height: 100,
                opacity: 100,
            });
            if (oUserLogout.style.height != 0 && oUserLogout.style.opacity != 0) {
                startMove(oUserLogout, {
                    height: 0,
                    opacity: 0,
                });
            }
        }
        oMenuDrop.onclick = function() {
            if (oMenu.style.left == '0px') {
                startMove(oMenu, {
                    left: -180
                })
                startMove(oContent, {
                    marginLeft: 10
                })
            } else if (oMenu.style.left != '0px') {
                startMove(oMenu, {
                    left: 0
                })
                startMove(oContent, {
                    marginLeft: 188
                })
            }
        }

        for (i = 0; i < aFirMenuText.length; i++) {
            aFirMenuText[i].onclick = function() {
                var aSecMenu = this.parentNode.getElementsByClassName('sec-menu')[0];
                var aDown = this.parentNode.getElementsByClassName('fa-caret-down')[0];
                var aRight = this.parentNode.getElementsByClassName('fa-caret-right')[0];
                var aSecMenuA = aSecMenu.getElementsByClassName('a');
                var Height = aSecMenu.offsetHeight;
                if (aSecMenu.className == 'sec-menu') {
                    addClass(aSecMenu, 'active');
                    aDown.style.display = 'inline-block';
                    aRight.style.display = 'none';
                } else if (aSecMenu.className == 'sec-menu active') {
                    removeClass(aSecMenu, 'active');
                    aDown.style.display = 'none';
                    aRight.style.display = 'inline-block';
                }
            }

        }
    }
</script>
<div class="g-heading f-cb">
    <div class="m-box f-cb">
        <div class="m-logo f-fl f-cb">
            <i class="fa fa-align-justify fa-2x" id="menu-dropdown"></i>
            <h2>S<b>M</b>System</h2>
        </div>
        <div class="m-user f-fr f-cb">
            <i class="fa fa-search fa-2x f-fl"></i>
            <div class="m-user-details f-fr">
                <img src="images/portrait.png" style="width: 50px;height: 50px;">
                <b><% out.println(session.getAttribute("UserName")); %></b>
                <span class="fa fa-caret-down fa-2x" id="user-dropdown"></span>
            </div>
            <div class="m-user-logout" id="user-logout">
                <i class="fa fa-caret-up fa-2x"></i>
                <div class="logout-bg">
                    <div class="logout-settings">
                        <i class="fa fa-cog"></i>
                        <b>Settings</b>
                    </div>
                </div>
                <div class="logout-text"><a href="logout.action">Logout</a></div>
            </div>
        </div>
    </div>
</div>
<div class="g-left" id="sidebar" style="left: 0px">
    <div class="fir-menu">
        <div class="fir-menu-text">
            <i class="fa fa-book"></i>
            <span>Student<i class="fa fa-caret-right"></i><i class="fa fa-caret-down"></i></span>
        </div>
        <div class="sec-menu">
            <a href="viewMark.action">View Mark</a>
        </div>
    </div>
    <div class="fir-menu">
        <div class="fir-menu-text">
            <i class="fa fa-star"></i>
            <span>Teacher<i class="fa fa-caret-right"></i><i class="fa fa-caret-down"></i></span>
        </div>
        <div class="sec-menu">
            <a href="viewMark.action">View Mark</a>
            <a href="updateMark.action">Update Mark</a>
        </div>
    </div>
    <div class="fir-menu">
        <div class="fir-menu-text">
            <i class="fa fa-user"></i>
            <span>Manager<i class="fa fa-caret-right"></i><i class="fa fa-caret-down"></i></span>
        </div>
        <div class="sec-menu">
            <a href="viewMark.action">View Mark</a>
            <a href="updateMark.action">Update Mark</a>
            <a href="updateUsers.action">Update Users</a>
        </div>
    </div>
</div>
