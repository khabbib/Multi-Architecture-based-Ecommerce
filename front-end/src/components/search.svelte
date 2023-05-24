<script>

    import jQuery from 'jquery'; // kör 'npm install jquery' i cmd
    
        const getProducts = async () => {
            console.log("Getting all products...");
    
            const data = await fetch('http://localhost:8085/products/', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify()
                })
                .then((res) => {
                    console.log(res)
                    displayProducts(res)
                    return res;
                })
                .catch((error) => console.error("FETCH ERROR:", error));
    
            function displayProducts(data) {
    
                // TODO: Display all products
                
                // Koden nedan är ett förslag... 
    
                /* 
                const product = data.product;
                console.log(data);
                const productDiv = document.getElementById("product"); 
                const heading = document.createElement("h1");
                heading.innerHTML = product;
                productDiv.appendChild(heading);
                
    
                console.log("Length: " + data.length);
    
                const list = jQuery('#products');
                for (var i = 0; data.length; i++) {
                    const html = '<h1 id="product_' + i + '">' + data[i]['name'] + '</li>';
                    list.append(html);
                }
                */
            }   
        }
        
    </script>
    
    <!-- svelte-ignore a11y-click-events-have-key-events -->
    <form on:click={getProducts} class="top-0">   
        <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
        <div class="relative ">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
            </div>
            <input type="search" id="default-search" class="block w-full p-4 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search Products..." required>
            <button type="submit" class="text-white absolute right-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search</button>
        </div>
    </form>
    
    <div id="product">product</div>
    
    <div id="products">products</div>
    