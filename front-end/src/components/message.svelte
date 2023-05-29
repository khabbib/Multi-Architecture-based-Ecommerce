<script>
	import { onMount } from 'svelte';
  
	export let error;
  
	onMount(() => {
	  setTimeout(() => {
		error = null; // Clear the error after 10 seconds
	  }, 10000);
	});
  </script>
  
<div>

	  {#if error !== null}
		  <h1 style="height: 2rem; color: {error.status === 'success' ? 'green' : 'red'};">{error.error}</h1>
	  {/if}
	  
</div>


<style>

	div {
		background-color: #f1f1f1;
		text-align: center;
		padding: 10px;
		margin-top: 10px;
	}

	/* The alert message box */
	.alert {
		padding: 20px;
		background-color: #f44336; /* Red */
		color: white;
		margin-bottom: 15px;
	}

	/* The close button */

	.closebtn {
		margin-left: 15px;
		color: white;
		font-weight: bold;
		float: right;
		font-size: 22px;
		line-height: 20px;
		cursor: pointer;
		transition: 0.3s;
	}

	/* When moving the mouse over the close button */
	.closebtn:hover {
		color: black;
	}


</style>