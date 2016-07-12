function validateForm() {
    var x = document.forms["frm1"]["name"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
}