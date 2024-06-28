document.addEventListener('DOMContentLoaded', function() {
    const outOfStockLabel = document.getElementById('outOfStockLabel');
    const addToCartButton = document.getElementById('addToCartButton');
    const stockSpan = document.querySelector('.stock span');

    // Giả sử chúng ta có một hàm kiểm tra số lượng hàng
    function checkStock() {
        // Trong trường hợp này, chúng ta lấy số lượng từ nội dung của stockSpan
        return parseInt(stockSpan.textContent.match(/\d+/)[0]);
    }

    const stock = checkStock();

    if (stock === 0) {
        outOfStockLabel.style.display = 'block';
        addToCartButton.disabled = true;
        stockSpan.textContent = 'Hết hàng';
    } else {
        outOfStockLabel.style.display = 'none';
        addToCartButton.disabled = false;
        // Giữ nguyên nội dung hiện tại của stockSpan
    }
});

