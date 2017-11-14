angular.module('infoApp').controller('AddController', function ($scope, $resource, $http) {
    $scope.message = 'Hello from AddController';
    $scope.gallery = [];

    $scope.saveEQ = function () {
        if ($scope.gallery.length === 0) {
            $scope.image = undefined;
        } else {
            if ($scope.gallery[0].indexOf('data:image/jpeg;base64,') >= 0) {
                $scope.image = $scope.gallery[0].replace('data:image/jpeg;base64,', '');
            }
            if ($scope.gallery[0].indexOf('data:image/png;base64,') >= 0) {
                $scope.image = $scope.gallery[0].replace('data:image/png;base64,', '');
            }
        }

        // console.log($scope.nazwaEQ, $scope.opisEQ);
        var nn = $scope.nazwaEQ;
        var oo = $scope.opisEQ;
        var eqObject = {
            name: nn,
            description: oo ,
            image: $scope.image
        };

        $http.post('/equipment/add', eqObject).success(function () { //wywloujemy

            loadAll();

            $scope.nazwaEQ = "";
            $scope.opisEQ = "";

        }).error(function () {
            alert("Error");

        })
    };


    // wyświetlanie aut
    var loadAll = function () {

        var Eque = $resource('equipment/all', {}, {
            query: {method: 'get', isArray: true, cancellable: true}

        });

        Eque.query(function (response) {

            // alert(response);
            $scope.eque = response; // widoku będziesz używał teraz people
             console.log(response);
        });
    };
    loadAll();


    $scope.delete = function (id) {
        $http({
            method: 'DELETE',
            url: '/equipment/delete/id/' + id
        }).success(function (data) {
            $scope.selectTitle = data.title;
            $scope.status = "The Survey Deleted Successfully!!!";
            loadAll();

        })
            .error(function (error) {
                //Showing error message
                $scope.status = 'Unable to delete a person: ' + error.message;
            });
    };





    //dodawanie zdjecia
    (function ($) {

        $.fn.imagePicker = function (options) {

            // Define plugin options
            var settings = $.extend({
                // Input name attribute
                name: "",
                // Classes for styling the input
                class: "form-control btn btn-default btn-block",
                // Icon which displays in center of input
                icon: "glyphicon glyphicon-plus"
            }, options);

            // Create an input inside each matched element
            return this.each(function () {
                $(this).html(create_btn(this, settings));
            });

        };

        // Private function for creating the input element
        function create_btn(that, settings) {
            // The input icon element
            var picker_btn_icon = $('<i class="' + settings.icon + '"></i>');

            // The actual file input which stays hidden
            var picker_btn_input = $('<input type="file" name="' + settings.name + '" />');

            // The actual element displayed
            var picker_btn = $('<div class="' + settings.class + ' img-upload-btn"></div>')
                .append(picker_btn_icon)
                .append(picker_btn_input);
            // File load listener
            picker_btn_input.change(function () {
                if ($(this).prop('files')[0]) {
                    // Use FileReader to get file
                    var reader = new FileReader();

                    // Create a preview once image has loaded
                    reader.onload = function (e) {
                        var preview = create_preview(that, e.target.result, settings);
                        $(that).html(preview);
                    }

                    // Load image
                    reader.readAsDataURL(picker_btn_input.prop('files')[0]);
                    // console.log(picker_btn_input.prop('files')[0]);
                    //MOJE
                    // alert(reader.readAsDataURL(picker_btn_input.prop('files')[0]));
                }
            });

            return picker_btn
        };

        // Private function for creating a preview element
        function create_preview(that, src, settings) {
            // The preview image
            var picker_preview_image = $('<img src="' + src + '" class="img-responsive img-rounded" />');
            //MOJE
            $scope.immmg = src;
            $scope.gallery.push(src);

            // The remove image buttoni
            var picker_preview_remove = $('<button class="btn btn-warning" id="delPhoto"><small>' +
                '<span class="glyphicon glyphicon glyphicon-trash"></span></small></button>');

            // The preview element
            var picker_preview = $('<div class="text-center"></div>')
                .append(picker_preview_image)
                .append(picker_preview_remove);

            // Remove image listener
            picker_preview_remove.click(function () {
                var btn = create_btn(that, settings);
                $(that).html(btn);
                $scope.gallery.splice($scope.gallery.indexOf(src), 1);
            });

            return picker_preview;
        };

    }(jQuery));

    $(document).ready(function () {
        $('.img-picker').imagePicker({name: 'images'});
    })
});

function Quantity(numOfPcs) {
    var mocAuto = numOfPcs;
    var capacityAutocapacityAuto = numOfPcs;

    this.__defineGetter__("qty", function () {
        return mocAuto;
    });

    this.__defineSetter__("qty", function (val) {
        val = parseInt(val);
        mocAuto = val;
        capacityAuto = val;
    });

    this.__defineGetter__("cap", function () {
        return capacityAuto;
    });

    this.__defineSetter__("cap", function (val) {
        val = parseInt(val);
        capacityAuto = val;
    });
}

;