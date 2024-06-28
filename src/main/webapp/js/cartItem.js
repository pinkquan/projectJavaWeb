document.addEventListener('DOMContentLoaded', function() {
        var shippingRadios = document.getElementsByName('shipping');
        var cartSubtotal = document.getElementById('cart-subtotal');
        var shippingCost = document.getElementById('shipping-cost');
        var cartTotal = document.getElementById('cart-total');

        // Function to update cart total based on shipping method
        function updateCartTotal() {
            var subtotal = parseInt(cartSubtotal.innerText.replace('Tạm tính: ', '').replace(' đ', '').trim(), 10);
            var shipping = 0;

            // Determine shipping cost based on selected shipping method
            for (var i = 0; i < shippingRadios.length; i++) {
                if (shippingRadios[i].checked) {
                    if (shippingRadios[i].value === 'standard') {
                        shipping = 0;
                    } else if (shippingRadios[i].value === 'express') {
                        shipping = 50000; // Example: 50,000 đ for express shipping
                    }
                    break;
                }
            }

            // Update shipping cost display
            shippingCost.innerText = 'Phí vận chuyển: ' + shipping + ' đ';

            // Update cart total
            var total = subtotal + shipping;
            cartTotal.innerText = 'Tổng cộng: ' + total + ' đ';
        }

        // Add event listener for shipping radios
        for (var i = 0; i < shippingRadios.length; i++) {
            shippingRadios[i].addEventListener('change', updateCartTotal);
        }

        // Initialize cart total on page load
        updateCartTotal();
});
