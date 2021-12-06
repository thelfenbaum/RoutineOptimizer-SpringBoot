var getPassword = function() {
    return fetch('http//localhost:8080/users/joanne').catch((reason) => {alert("wrong pass")});
}

var getInfo = async function() {
    return await getPassword();
}