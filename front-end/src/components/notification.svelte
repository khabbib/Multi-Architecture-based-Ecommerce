<script>
	const imageUrl = {
		src: 'https://picsum.photos/200/300',
		title: 'Image title',
		message: 'This image is from picsum.photos'
	};

	/**
	 *
	 * @param {MouseEvent} e
	 */
	function addToCard(e) {
		console.log('Added to the card', e.target);
	}
</script>

<div class="p-6 max-w-sm mx-auto bg-white rounded-xl shadow-md items-center space-x-4">
	<div class="flex p-6 gap-3 items-center">
		<div class="shrink-0">
			<img class="h-12 w-12" src={imageUrl.src} alt={imageUrl.message} />
		</div>
		<div>
			<div class="text-xl font-medium text-black">{imageUrl.title}</div>
			<p class="text-slate-500">{imageUrl.message}</p>
		</div>
	</div>
	<div class="flex">
		<button
			class="py-2 px-4 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75"
			on:click={(e) => addToCard(e)}>Add to card</button
		>
	</div>
</div>
