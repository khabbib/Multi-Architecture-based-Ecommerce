<script>
	// IMPORTS
	import { onMount } from 'svelte';
	import { getAllProducts } from '../../events/util.js';
	import { getSearchedProduct } from '../../events/util.js';
	import Card from '../../components/card.svelte';
	import Search from '../../components/search.svelte';

	let products = [];
	let query = '';
	let search = [];
	let isSearching = false;
	let resultMessage = '';

	onMount(async () => {
		const result = await getAllProducts();
		if (result) {
			products = result;
		}
	});
	const handleSearch = async (value) => {
		query = value.detail;
		isSearching = true;
		search = await getSearchedProduct(query);
		console.log('Search:', search);
		if (search.length == 0) {
			resultMessage = 'Result for "' + query + '" not found.';
		} else {
			resultMessage = 'Result for "' + query + '":';
		}
		isSearching = false;
	};
</script>

<div class="bg-green-50 p-5 h-[80vh]" style="overflow: scroll;">
	

	<!-- Search component -->
	<Search on:search={handleSearch} />

	<div style="width: 100%; height: 1px; background: gray; margin: 2rem 0;"></div>
	{#if isSearching}
		<p>Searching...</p>
	{:else}
		<p>{resultMessage}</p>
		{#if search.length > 0}
			<!-- Product card comp -->
			<Card products={search} />
			{/if}
	{/if}

	{#if products.length > 0 && search.length == 0 && query.length == 0}
		<h1>Available Products:</h1>
		{#if products.length > 0}
			<!-- Product card comp -->
			<Card products={products} />
		{/if}
	{/if}
</div>
