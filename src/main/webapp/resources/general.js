/**
 * Created by Tomek on 23.04.2016.
 */
function validationSucess(el) {
    el.addClass('has-success');
}

function validationError(el) {
    el.addClass('has-error');
}

function resetValidation(el) {
    el.removeClass('has-error');
    el.removeClass('has-success');
}

function showEl(el) {
    el.removeClass('displayNone');
    el.addClass('displayBlock');
}

function hideEl(el) {
    el.removeClass('displayBlock');
    el.addClass('displayNone');
}

function showElInline(el) {
    el.removeClass('displayNone');
    el.addClass('displayInline');
}

function hideElInline(el) {
    el.removeClass('displayInline');
    el.addClass('displayNone');
}

function validateField(elem, regex) {
    var regexString = regex;
    var input = elem;
    resetValidation(input.parent());
    if(regexString.test(input.val())) {
        validationSucess(input.parent());
    } else {
        validationError(input.parent());
    }
    displayValidationMessages();
}

function isFieldValid(elem, regex) {
    var regexString = regex;
    var input = elem;
    resetValidation(input.parent());
    if(regexString.test(input.val())) {
        return true;
    } else {
        return false;
    }
}

function validateMatching(parent, child) {
    resetValidation(child.parent());
    if(parent.val() == child.val()) {
        validationSucess(child.parent());
    } else {
        validationError(child.parent());
    }
}

function isFromValid(form) {
    var validForm = true;
    console.log('ss');
    form.find('div').each(function(index, element) {
        if($(this).hasClass('has-error')) {
            validForm = false;
        }
    });
    if(validForm) {
        if($('#usernameInput').hasClass('has-success')) {
            enableButton($('#createNewUserButton'));
            hideElInline($('#createNewUserButtonDisabled'));
            showElInline($('#createNewUserButton'));
        } else {
            disableButton($('#createNewUserButton'));
            showElInline($('#createNewUserButtonDisabled'));
            hideElInline($('#createNewUserButton'));
        }
    } else {
        disableButton($('#createNewUserButton'));
        showElInline($('#createNewUserButtonDisabled'));
        hideElInline($('#createNewUserButton'));

    }
}

function disableButton(el) {
    console.log("disabled");

    el.removeClass('btn-primary');
    el.removeClass('btn-default');
    el.addClass('disabled');
}

function enableButton(el) {
    console.log("enabled");
    el.removeClass('disabled');
    el.addClass('btn-primary');
}

function displayValidationMessages() {
    var validationMessages = [];

    if($('#nameInput').parent().hasClass('has-error')) {
        validationMessages.push("Name is required, can't contain numbers </br>");
    }
    if($('#lastNameInput').parent().hasClass('has-error')) {
        validationMessages.push("Surname is required, can't contain numbers</br>");
    }
    if($('#address1Input').parent().hasClass('has-error')) {
        validationMessages.push("Address is required</br>");
    }
    if($('#cityInput').parent().hasClass('has-error')) {
        validationMessages.push("City is required, can't contain numbers</br>");
    }
    if($('#dateInput').parent().hasClass('has-error')) {
        validationMessages.push("Date is required, correct format yyyy-mm-dd</br>");
    }
    if($('#usernameInput').parent().hasClass('has-error')) {
        validationMessages.push("Username is required, e.g. tommy_91</br>");
    }
    if($('#mailInput').parent().hasClass('has-error')) {
        validationMessages.push("E-mail address is required, e.q. tommy@domain.com</br>");
    }
    if($('#passwordInput').parent().hasClass('has-error')) {
        validationMessages.push("Password is required, must be at least 6 char long, must contain at least one capital letter, and one number</br>");
    }

    var messageDiv = document.getElementById('messagesDiv');
    if(validationMessages.length > 0) {
        showEl($('#messagesDiv'));
        var resultMessage = "";
        messageDiv.innerHTML = "";
        var arraySize = validationMessages.length;
        console.log(validationMessages);
        console.log(validationMessages.length);
        for(var i = 0; i < arraySize; i++) {
            resultMessage += validationMessages.shift();
            console.log(i);
        }
        console.log(resultMessage);

        messageDiv.innerHTML = resultMessage;
    } else {
        hideEl($('#messagesDiv'));
        messageDiv.innerHTML = "";
    }
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function capitalize(el) {
    var string = el.val();
    var result;
    result = capitalizeFirstLetter(string);
    el.val('');
    el.val(result);
}


