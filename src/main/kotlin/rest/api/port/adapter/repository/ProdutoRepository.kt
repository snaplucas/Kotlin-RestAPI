package rest.api.port.adapter.repository

import org.springframework.data.jpa.repository.JpaRepository
import rest.api.domain.model.entities.Produto

interface ProdutoRepository : JpaRepository<Produto, Long>