function checkValue(obj, msg) {
	var objvalue = obj.value;
	if (objvalue == "") {
		alert(msg);
		obj.focus();
		return true; 
	} 
	return false;	
}

		