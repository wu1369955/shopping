function clickCounter(goods, id) {
    var input = document.getElementById(id).value
    var str = goods + id;
    document.cookie = str + "=" + input + ";";
    console.log(document.cookie)
}