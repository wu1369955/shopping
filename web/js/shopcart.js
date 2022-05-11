window.onload = function () {
    //兼容document.getElementsByClassName 方法；
    if (!document.getElementsByClassName) {
        document.getElementsByClassName = function (cls) {
            var ret = [];
            var els = document.getElementsByTagName('*');
            for (var i = 0; i < els.length; i++) {
                if (els[i].className === cls
                    || els[i].className.indexOf(cls + ' ') >= 0
                    || els[i].className.indexOf(' ' + cls) >= 0
                    || els[i].className.indexOf(' ' + cls + ' ') >= 0) {
                    ret.push(els[i]);
                }
            }
            ;
            return ret;
        }
    }
    var cartTable = document.getElementById('cartTable');
    var tr = cartTable.children[1].rows; //children子节点;
    var checkInputs = document.getElementsByClassName('check');
    var checkAllInput = document.getElementsByClassName('check-all');
    var selectedTotal = document.getElementById('selectedTotal');
    var priceTotal = document.getElementById('priceTotal');
    var selected = document.getElementById('selected');
    var cartFooter = document.getElementById('cartFooter');
    var selectedViewList = document.getElementById('selectedViewList');
    var multiDelete = document.getElementById('multiDelete');
    var allDelete = document.getElementById('allDelete');
    var selallSPAN = document.getElementsByClassName('selallSPAN');

    //选择框事件；
    for (var i = 0; i < checkInputs.length; i++) {
        checkInputs[i].onclick = function () {
            if (this.className === 'check-all check') { //全选；
                for (var j = 0; j < checkInputs.length; j++) {
                    checkInputs[j].checked = this.checked;
                }
            }
            ;
            if (this.checked == false) {
                for (var k = 0; k < checkAllInput.length; k++) {
                    checkAllInput[k].checked = false;
                }
            }
            getTotal();
        }
    }
    ;
    selallSPAN[0].onclick = selallSPAN[1].onclick = function () {
        for (var k = 0; k < checkAllInput.length; k++) {
            if (checkAllInput[k].checked) {
                checkAllInput[k].checked = false;

            } else {
                checkAllInput[k].checked = true;
            }
        }
        for (var j = 0; j < checkInputs.length; j++) {
            checkInputs[j].checked = checkAllInput[0].checked;
        }
        getTotal();
    }

    //计算；
    function getTotal() {
        var selected = 0;
        var price = 0;
        var HTMLstr = '';
        for (var i = 0; i < tr.length; i++) {
            var perCount = tr[i].getElementsByTagName('input')[1].value;
            if (tr[i].getElementsByTagName('input')[0].checked) {
                tr[i].className = "on";
                selected += parseInt(tr[i].getElementsByTagName('input')[1].value);
                price += parseFloat(tr[i].cells[4].innerHTML);
                HTMLstr += '<div><img src="' + tr[i].getElementsByTagName('img')[0].src + '"/><span class="selCount">' + perCount + '</span><span class="del" index="' + i + '">取消选择</span></div>'
            } else {
                tr[i].className = " ";
            }
        }
        ;
        selectedTotal.innerHTML = selected;
        priceTotal.innerHTML = price.toFixed(2);
        selectedViewList.innerHTML = HTMLstr;
        //选中0时；
        if (selected == 0) {
            cartFooter.className = "cartFooter";
        }
    }

    //已选框的显示与隐藏；
    selected.onclick = function () {
        if (cartFooter.className == 'cartFooter') {
            if (selectedTotal.innerHTML != 0) {
                cartFooter.className = 'cartFooter show';
            }
        } else {
            cartFooter.className = "cartFooter";
        }
    }

    //取消选择---》事件代理
    selectedViewList.onclick = function (e) {
        e = e || window.event;
        var el = e.srcElement;
        if (el.className == "del") {
            var index = el.getAttribute('index');
            var input = tr[index].getElementsByTagName('input')[0];
            input.checked = false;
            input.onclick();
        }
    }

    //加减事件；
    for (var i = 0; i < tr.length; i++) {
        //加减按钮；
        tr[i].onclick = function (e) {
            e = e || window.event;
            document.onselectstart = new Function("event.returnValue=false;");
            var el = e.target || e.srcElement;
            var cls = el.className;
            var input = this.getElementsByTagName('input')[1];
            var val = parseInt(input.value);
            var reduce = this.getElementsByTagName('span')[3];
            switch (cls) {
                case 'add':
                    input.value = val + 1;
                    reduce.innerHTML = '-';
                    getSubtotal(this);
                    break;
                case 'reduce':
                    if (val > 1) {
                        input.value = val - 1;
                        getSubtotal(this);
                    }
                    if (input.value <= 1) {
                        reduce.innerHTML = '';
                    }
                    break;
                case 'deleteOne':
                    //单行删除；
                    var conf = confirm('确定要删除吗？');
                    if (conf) {
                        this.parentNode.removeChild(this);
                    }
                    break;
                default:
                    break;
            }
            getTotal();
        }
        //input输入事件；
        tr[i].getElementsByTagName('input')[1].onkeyup = function () {
            var val = parseInt(this.value);
            var tr = this.parentNode.parentNode;
            var reduce = tr.getElementsByTagName('span')[3];
            if (isNaN(val) || val < 1) {
                val = 1;
            }
            this.value = val; //输入控制法；
            if (val <= 1) {
                reduce.innerHTML = "";
            } else {
                reduce.innerHTML = "-";
            }
            getSubtotal(tr);
            getTotal();
        }
    }
    ;

    //小计
    function getSubtotal(tr) {
        var tds = tr.cells;
        var price = parseFloat(tds[2].innerHTML);
        var count = tr.getElementsByTagName('input')[1].value;
        var subTotal = parseFloat(price * count).toFixed(2);
        tds[4].innerHTML = subTotal;
    }

    //删除；
    multiDelete.onclick = function () {
        if (selectedTotal.innerHTML != '0') {
            var conf = confirm('确定删除吗？');
            if (conf) {
                cartDel();
                getTotal();
            }
        }
    }
    allDelete.onclick = function () {
        var conf = confirm('确定清空购物车吗？');
        if (conf) {
            checkAllInput[0].checked = true;
            checkAllInput[0].onclick();
            cartDel();
            getTotal();
        }
    }

    function cartDel() {
        for (var i = 0; i < tr.length; i++) {
            var input = tr[i].getElementsByTagName('input')[0];
            if (input.checked) {
                tr[i].parentNode.removeChild(tr[i]);
                i--; //删除时注意i 的变化；
            }
            ;
        }
        ;
    }
}