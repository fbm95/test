function validateForm() {
    var x = document.forms["frm1"]["name"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
    var x = document.forms["frm1"]["email"].value;
    if (x == null || x == "") {
        alert("Email must be filled out");
        return false;
    }

}