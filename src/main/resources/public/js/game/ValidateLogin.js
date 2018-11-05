define(function(require){

    // query the server if the user is authentic
    jQuery.post('/authenticate', '',
        function(isAuthenticated, textStatus, jqXHR) {
            console.info('Is user Authenticated =' + isAuthenticated);
            if (isAuthenticated) {
                window.location.replace('/lobby');
            } else {
                return window.alert("User Name already Exist. Please try again with a different user name")
            }
            handleResponse(view, isMyTurn);
        },
        'json');

    // export class constructor
    return ValidateLogin;
}