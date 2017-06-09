package rest.api.port.adapter.repository

import org.springframework.data.repository.CrudRepository
import rest.api.domain.model.entities.Produto

interface ProdutoRepository : CrudRepository<Produto, Long>