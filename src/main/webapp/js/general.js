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