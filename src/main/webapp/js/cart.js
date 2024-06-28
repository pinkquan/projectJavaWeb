// Khởi tạo giỏ hàng từ localStorage hoặc tạo mới nếu chưa có
let cart = JSON.parse(localStorage.getItem('cart')) || [];
let shippingMethod = 'standard';

// Hàm thêm sản phẩm vào giỏ hàng
function addToCart(name, price, image) {
    console.log('Adding to cart:', name, price, image);
    let numericPrice = parseFloat(price.replace(/[^\d]/g, ''));
    
    // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
    let existingItem = cart.find(item => item.name === name);
    
    if (existingItem) {
        // Nếu sản phẩm đã tồn tại, tăng số lượng
        existingItem.quantity += 1;
    } else {
        // Nếu sản phẩm chưa tồn tại, thêm mới vào giỏ hàng
        cart.push({ id: Date.now(), name, price: numericPrice, image, quantity: 1 });
    }
    
    saveCart();
    updateCartCount();
    showNotification(`Đã thêm ${name} vào giỏ hàng!`);
}

// Lưu giỏ hàng vào localStorage
function saveCart() {
    localStorage.setItem('cart', JSON.stringify(cart));
}

// Cập nhật số lượng sản phẩm hiển thị trên icon giỏ hàng
function updateCartCount() {
    const cartCount = document.querySelector('.cart-count');
    if (cartCount) {
        cartCount.textContent = cart.length;
    }
}

// Cập nhật hiển thị các mục trong giỏ hàng
function updateCartItems() {
    const cartItemsContainer = document.querySelector('#cart-items tbody');
    const cartSubtotalElement = document.getElementById('cart-subtotal');
    const cartTotalElement = document.getElementById('cart-total');
    const shippingCostElement = document.getElementById('shipping-cost');

    if (!cartItemsContainer) return;

    cartItemsContainer.innerHTML = '';
    let subtotal = 0;

    cart.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td><img src="${item.image}" alt="${item.name}" class="item-image" width="50"></td>
            <td class="item-name">${item.name}</td>
            <td class="item-price">${formatCurrency(item.price)}</td>
            <td><input type="number" class="item-quantity" value="${item.quantity}" min="1"></td>
            <td class="item-total">${formatCurrency(item.price * item.quantity)}</td>
            <td><button class="remove-item">Xóa</button></td>
        `;

        row.querySelector('.item-quantity').addEventListener('change', function() {
            updateItemQuantity(item.id, this.value);
        });

        row.querySelector('.remove-item').addEventListener('click', function() {
            removeFromCart(item.id);
        });

        cartItemsContainer.appendChild(row);

        subtotal += item.price * item.quantity;
    });

    const shippingCost = calculateShippingCost();
    const total = subtotal + shippingCost;

    if (cartSubtotalElement) cartSubtotalElement.textContent = 'Tạm tính: ' + formatCurrency(subtotal);
    if (shippingCostElement) shippingCostElement.textContent = 'Phí vận chuyển: ' + formatCurrency(shippingCost);
    if (cartTotalElement) cartTotalElement.textContent = 'Tổng cộng: ' + formatCurrency(total);
}

// Cập nhật số lượng sản phẩm
function updateItemQuantity(itemId, newQuantity) {
    const item = cart.find(i => i.id === itemId);
    if (item) {
        item.quantity = parseInt(newQuantity);
        saveCart();
        updateCartItems();
    }
}

// Xóa sản phẩm khỏi giỏ hàng
function removeFromCart(itemId) {
    cart = cart.filter(item => item.id !== itemId);
    saveCart();
    updateCartItems();
    updateCartCount();
}

// Tính phí vận chuyển
function calculateShippingCost() {
    return shippingMethod === 'express' ? 50000 : 0;
}

// Định dạng tiền tệ
function formatCurrency(amount) {
    return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(amount);
}

// Hiển thị thông báo
function showNotification(message) {
    const notification = document.createElement('div');
    notification.className = 'notification';
    notification.textContent = message;
    document.body.appendChild(notification);

    // Trigger reflow
    notification.offsetHeight;

    // Add 'show' class to start the fade-in effect
    notification.classList.add('show');

    // Remove the notification after 3 seconds
    setTimeout(() => {
        notification.classList.remove('show');
        setTimeout(() => {
            document.body.removeChild(notification);
        }, 500);
    }, 3000);
}
document.addEventListener('DOMContentLoaded', function() {
    updateCartCount();
    updateCartItems();

    // Xử lý nút thêm vào giỏ hàng trên trang index và trang chi tiết sản phẩm
    const addToCartButtons = document.querySelectorAll('.add-to-cart-btn');
    addToCartButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết
            
            let name, price, image;
            
            if (this.closest('.portfolio-item')) {
                // Trường hợp trang index
                const product = this.closest('.portfolio-item');
                name = product.querySelector('.portfolio-info h4').textContent;
                price = product.querySelector('.portfolio-info p').textContent;
                image = product.querySelector('img').src;
            } else {
                // Trường hợp trang chi tiết sản phẩm
                name = document.querySelector('.product-info h1').textContent;
                price = document.querySelector('.product-info .price').textContent;
                image = document.querySelector('.product-image img').src;
            }

            if (name && price && image) {
                addToCart(name, price, image);
            } else {
                console.error("Some product elements are missing");
            }
        });
    });

    // Xử lý form phương thức vận chuyển
    const shippingForm = document.getElementById('shipping-form');
    if (shippingForm) {
        shippingForm.addEventListener('change', function(e) {
            shippingMethod = e.target.value;
            updateCartItems();
        });
    }
});