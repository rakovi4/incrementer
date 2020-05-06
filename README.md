# incrementer

<h3>Prerequisites</h3>
<a href="https://docs.docker.com/engine/install/">Docker</a>

<h3>Deployment</h3>

```
git clone git@github.com:rakovi4/incrementer.git
cd incrementer
make all
```

<h3>Undeploy</h3>

```
make clean
```

<h3>Test</h3>

To get number:

`curl -i http://localhost:8080/incrementer/api/incrementer/number` 

To increment number:

`curl -i http://localhost:8080/incrementer/api/incrementer/increment`

To set max val:

`curl -i http://localhost:8080/incrementer/api/incrementer/setMax?maxVal=3`
