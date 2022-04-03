$("#employee").click(function(){
    $('#customer-content').addClass("d-none");
    $('#service-content').addClass("d-none");
    $('#employee-content').removeClass("d-none");
})

$("#customer").click(function(){
    $('#employee-content').addClass('d-none');
    $('#service-content').addClass('d-none');
    $('#customer-content').removeClass('d-none');
})

$("#service").click(function(){
    $("#employee-content").addClass('d-none');
    $("#customer-content").addClass('d-none');
    $("#service-content").removeClass('d-none');
})

$('#show-Employee-List').click(function(){
    $('#employee-list').removeClass("d-none");
    $('#add-employee-form').addClass("d-none");
})

$('#add-employee').click(function(){
    $('#add-employee-form').removeClass('d-none');
    $('#employee-list').addClass('d-none');
})

$('#show-Customer-List').click(function(){
    $('#customer-list').removeClass("d-none");
    $('#add-customer-form').addClass("d-none");
})

$('#add-customer').click(function(){
    $('#add-customer-form').removeClass('d-none');
    $('#customer-list').addClass("d-none");
})

$('#addNewFacility').click(function(){
    $('#facilitySubmenu').removeClass('d-none');
})