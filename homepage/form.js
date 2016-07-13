function validateForm() {
    //First Name Validation 
    var fn=document.getElementById('name').value;
    if(fn == ""){
        alert('Please Enter Name');
        document.getElementById('name').style.borderColor = "red";
        return false;
    }else{
        document.getElementById('name').style.borderColor = "green";
    }
    if (/^[0-9]+$/.test(document.getElementById("name").value)) {
        alert("Name Contains Numbers!");
        document.getElementById('name').style.borderColor = "red";
        return false;
    }else{
        document.getElementById('name').style.borderColor = "green";
    }
    if(fn.length <=2){
        alert('Your Name is To Short');
        document.getElementById('name').style.borderColor = "red";
        return false;
    }else{
        document.getElementById('name').style.borderColor = "green";
    }

}