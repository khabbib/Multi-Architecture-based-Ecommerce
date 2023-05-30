<script>
	import Table from "../../components/table.svelte";
	import Miniheader from "../../components/dashboard/miniheader.svelte";
	import Header from "../../components/dashboard/header.svelte";
	import Model from "../../components/dashboard/model.svelte";
</script>

<div class="bg-green-50">
	<div class="flex items-center justify-center flex-col h-[80vh] gap-10">
		<h1 class="text-4xl font-bold">About us</h1>
	</div>
</div>


<Model data={"ic"}/>
<Header data={"ic"}/>
<Miniheader data={"ic"}/>

<Table />

