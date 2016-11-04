/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.Estudiante;



/**
 *
 * @author hcadavid
 */
public interface DaoUsuario {

    
    public Estudiante load(String email) throws PersistenceException;
    
    public void save(Estudiante p) throws PersistenceException;
    
    public void update(Estudiante p) throws PersistenceException;
    
    
}
