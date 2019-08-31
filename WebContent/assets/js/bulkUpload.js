var oFileMerchantIn;
var oFileAccountIn;
var merchantBulkData;
var accountBulkData;

jQuery(document).ready(function() {
    oFileMerchantIn = document.getElementById('filenameMerchant');
    if(oFileMerchantIn.addEventListener) {
        oFileMerchantIn.addEventListener('change', filePickedMerchant, false);
    }
    
    oFileAccountIn = document.getElementById('filenameAccount');
    if(oFileAccountIn.addEventListener) {
        oFileAccountIn.addEventListener('change', filePickedAccount, false);
    }
});



function filePickedMerchant(oEvent) {
    // Get The File From The Input
    var oFile = oEvent.target.files[0];
    var sFilename = oFile.name;
    // Create A File Reader HTML5
    var reader = new FileReader();
    
    // Ready The Event For When A File Gets Selected
    reader.onload = function(e) {
        var data = e.target.result;
        var cfb = XLS.CFB.read(data, {type: 'binary'});
        var wb = XLS.parse_xlscfb(cfb);
        // Loop Over Each Sheet
        wb.SheetNames.forEach(function(sheetName) {
            // Obtain The Current Row As CSV
            var sCSV = XLS.utils.make_csv(wb.Sheets[sheetName]);   
            var oJS = XLS.utils.sheet_to_row_object_array(wb.Sheets[sheetName]);   

            //$("#my_file_output").html(sCSV);
            merchantBulkData = oJS;
            
            console.log(oJS)
        });
    };
    
    // Tell JS To Start Reading The File.. You could delay this if desired
    reader.readAsBinaryString(oFile);
}

function filePickedAccount(oEvent) {
    // Get The File From The Input
    var oFile = oEvent.target.files[0];
    var sFilename = oFile.name;
    // Create A File Reader HTML5
    var reader = new FileReader();
    
    // Ready The Event For When A File Gets Selected
    reader.onload = function(e) {
        var data = e.target.result;
        var cfb = XLS.CFB.read(data, {type: 'binary'});
        var wb = XLS.parse_xlscfb(cfb);
        // Loop Over Each Sheet
        wb.SheetNames.forEach(function(sheetName) {
            // Obtain The Current Row As CSV
            var sCSV = XLS.utils.make_csv(wb.Sheets[sheetName]);   
            var oJS = XLS.utils.sheet_to_row_object_array(wb.Sheets[sheetName]);   

            //$("#my_file_output").html(sCSV);
            accountBulkData = oJS;
            console.log(oJS)
        });
    };
    
    // Tell JS To Start Reading The File.. You could delay this if desired
    reader.readAsBinaryString(oFile);
}