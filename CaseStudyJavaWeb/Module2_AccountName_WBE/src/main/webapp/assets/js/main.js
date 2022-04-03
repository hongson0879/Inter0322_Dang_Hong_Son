$("#employee").click(function(){
    $('#customer-content').addClass("d-none");
    $('#service-content').addClass("d-none");
    $('#employee-content').removeClass("d-none");
})

$("#customer").click(function(){
    // $('#customer-content').load('/customer/customer.jsp');
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

$('#add-service').click(function () {
    $('#add-service-form').removeClass('d-none');
    $('#service-list').addClass('d-none');
})

$('#serviceType').change(function () {
    if($(this).val() == 2){
        $('#poolArea').attr('disabled', 'disabled');
    }
    if($(this).val() == 3){
        $('#descriptionOtherConvenience').attr('disabled', 'disabled');
        $('#poolArea').attr('disabled', 'disabled');
        $('#numberOfFloors').attr('disabled', 'disabled');
        $('#standard').attr('disabled', 'disabled');
    }
})
