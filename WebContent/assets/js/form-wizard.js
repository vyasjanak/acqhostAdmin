var FormWizard = function () {
    debugger
	"use strict";
    var wizardContent = $('#wizard');
    var wizardForm = $('#form');
    var numberOfSteps = $('.swMain > ul > li').length;
    var initWizard = function () {
        debugger
        // function to initiate Wizard Form
        wizardContent.smartWizard({
            selected: 0,
            keyNavigation: false,
            onLeaveStep: leaveAStepCallback,
            onShowStep: onShowStep,
        });
        var numberOfSteps = 0;
        initValidator();
    };
    
     
    var initValidator = function () {
        debugger
        $.validator.setDefaults({
            errorElement: "span", // contain the error msg in a span tag
            errorClass: 'help-block',
            ignore: ':hidden',
            rules: {
                merchantName: {
                    minlength: 3,
                    required: true
					//symbol:false
                },
                businessName: {
                    minlength: 3,
                    required: true
                },
                contactPerson: {
                    minlength: 3,
                    required: true,
					number:false,
                },
                contactNumber : {
                    minlength: 10,
                    required: true,
					number: true,
                },
                emailId: {
                    required: true,
                    email: true
                },
                address1: {
                    minlength: 5,
                    required: true
                },
                state: {
                    required: true
                },
                city: {
                    required: true
                },
                pin: {
                    required: true,
                    number: true,
                    minlength: 6,
                    maxlength: 6
                },
                merchantReturnURL: {
                    minlength: 8,
                    required: true
                },
                kycAddressProofId: {
                    required: true
                },
                kycAddressProofNumber: {
                    required: true,
                    minlength: 6,
                },
                /*kycpancardid: {
                    required: true,
                    minlength: 4,
                },*/
				kycPanCardId: {
                    required: true
                },
                kycPanCardNumber: {
                    required: true,
                    minlength: 4,
                },
                mmdrBankId: {
                    required: true,
                },
                instrumentId: {
                    required: true,
                },
                startDate: {
                    required: true
                },
                endDate: {
                    required: true
                },
                mmdrMdrType: {
                    required: true
                },
                mmdrAggrMdr: {
                    required:true
                },
                mmdrBankMdr: {
                    required: true
                },
                mmdrResellerMdr: {
                    required:true
                },
                mmdrMinAmt: {
                    required:true,
					number:true,
                },
                mmdrMaxAmt: {
                    required:true,
					number:true,
                },
                mid :{
                    required: true
                },
                tid: {
                    required: true
                },
                productId: {
                    required:true
                },
                accountNumber: {
                    required: true,
                    number: true,
                },
                ifscCode:{
                    required: true
                },
                bankName: {
                    required:true,
					number:false,
					
                }
               // password2: {
                //    required: true,
                 //   minlength: 5,
                  //  equalTo: "#password"
                //}
            },
            messages: {
                merchantName: {
					required:"Merchant Name is required",
					//symbol: "Special Characters are not allowed.",
				},
                businessName: "Business Name is required",
                contactPerson: 
				{
					required:"Contact Person is required",
					number:"Numbers not allowed"
				},
                contactNumber: {
                    required: "Contact Number is required",
                    minlength:"Contact No will be of 10 digits",
					number: "Must be Numbers"
                },               
                emailId: {
                    required: "Email is required",
                    email: "Your email address must be in the format of name@domain.com"
                },
                address1: "Address1 is required",
                state: "State is required",
                city: "City is required",
                pin: "Valid Pin is required",
                merchantReturnURL: {
					required:"Return URL is required",
				},
                kycAddressProofId: "Kyc Address Proof is required",
                kycAddressProofNumber: "Kyc Proof number is required",
                //kycPanCardId: "Photo proof id is required",
				kycPanCardId:"Photo proof is required",
                kycPanCardNumber: "Photo proof number is required",
                mmdrBankId: "Bank is required",
                instrumentId: "Instrument is required",
                startDate: "Start Date is required",
                endDate: "End date is required",
                mmdrMdrType: "Mdr Type is required",
                mmdrAggrMdr: "Aggr MDR is required",
                mmdrBankMdr: "Bank MDR is required",
                mmdrResellerMdr: "Reseller MDR is required",
                mmdrMinAmt:{ 
				required:"Min Amount is required",
				number:"Only Numeric"
				},
                mmdrMaxAmt:{
				required :"Max Amount is required",
				number: "Only Numeric"
				},
                mid: "MID is required",
                tid: "MID is required",
                productId: "Product Id is required",
                accountNumber:{
                    required: "Account No is required",
                    number:"Account No must be in numeric"
                    },
                ifscCode: "IFSC code is required",
                bankName:
				{
					required:"Bank Name is required",
					number:"Number not allowed"
				}
            },
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('valid');
                // display OK icon
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error');
                // set error class to the control group
            },
            success: function (label, element) {
                label.addClass('help-block valid');
                // mark the current input as valid and display OK icon
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
            }
        });
    };
    var displayConfirm = function () {
        $('.display-value', form).each(function () {
            var input = $('[name="' + $(this).attr("data-display") + '"]', form);
            if (input.attr("type") == "text" || input.attr("type") == "email" || input.is("textarea")) {
                $(this).html(input.val());
            } else if (input.is("select")) {
                $(this).html(input.find('option:selected').text());
            } else if (input.is(":radio") || input.is(":checkbox")) {

                $(this).html(input.filter(":checked").closest('label').text());
            } else if ($(this).attr("data-display") == 'card_expiry') {
                $(this).html($('[name="card_expiry_mm"]', form).val() + '/' + $('[name="card_expiry_yyyy"]', form).val());
            }
        });
    };
    var onShowStep = function (obj, context) {
        debugger
    	if(context.toStep == numberOfSteps){
    		$('.anchor').children("li:nth-child(" + context.toStep + ")").children("a").removeClass('wait');
            displayConfirm();
    	}
    	$(".next-step").unbind("click").click(function (e) {
    	    debugger
            e.preventDefault();
            wizardContent.smartWizard("goForward");
        });
    	$(".back-step").unbind("click").click(function (e) {
    	    debugger
            e.preventDefault();
            wizardContent.smartWizard("goBackward");
        });
        $(".go-first").unbind("click").click(function (e) {
            e.preventDefault();
            wizardContent.smartWizard("goToStep", 1);
        });
        $(".finish-step").unbind("click").click(function (e) {
            e.preventDefault();
            onFinish(obj, context);
        });
    };
    var leaveAStepCallback = function (obj, context) {
        return validateSteps(context.fromStep, context.toStep);
        // return false to stay on step and true to continue navigation
    };
    var onFinish = function (obj, context) {
        if (validateAllSteps()) {
            alert('form submit function');
            $('.anchor').children("li").last().children("a").removeClass('wait').removeClass('selected').addClass('done').children('.stepNumber').addClass('animated tada');
            //wizardForm.submit();
        }
    };
    var validateSteps = function (stepnumber, nextstep) {
        var isStepValid = false;
        debugger
        
       
        if (numberOfSteps >= nextstep && nextstep > stepnumber) {
            if (((stepnumber == 3 && nextstep == 4) && $(".addNewTable tbody tr").length > 0) || ((stepnumber == 4 && nextstep == 5) && $(".addNewAccountTable tbody tr").length > 0))
            {
                for (var i=stepnumber; i<=nextstep; i++){
                    $('.anchor').children("li:nth-child(" + i + ")").not("li:nth-child(" + nextstep + ")").children("a").removeClass('wait').addClass('done').children('.stepNumber').addClass('animated tada');
                }
                //focus the invalid fields
                isStepValid = true;
                return true;
            }
            else
                
            //$(".addNewTable tbody tr").length
            // cache the form element selector
            if (wizardForm.valid()) { // validate the form
                wizardForm.validate().focusInvalid();
                for (var i=stepnumber; i<=nextstep; i++){
        		$('.anchor').children("li:nth-child(" + i + ")").not("li:nth-child(" + nextstep + ")").children("a").removeClass('wait').addClass('done').children('.stepNumber').addClass('animated tada');
        		}
                //focus the invalid fields
                isStepValid = true;
                return true;
            };
        } else if (nextstep < stepnumber) {
        	for (i=nextstep; i<=stepnumber; i++){
        		$('.anchor').children("li:nth-child(" + i + ")").children("a").addClass('wait').children('.stepNumber').removeClass('animated tada');
        	}
            
            return true;
        } 
    };
    var validateAllSteps = function () {
        var isStepValid = true;
        // all step validation logic
        return isStepValid;
    };
    return {
        init: function () {
            initWizard();
        }
    };
}();